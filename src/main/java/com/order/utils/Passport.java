package com.order.utils;

import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;


public class Passport {
	private byte version;
	private String id;
	private String subId;
	private String partitionId;
	private String cardId;
	private boolean shopOwner;
	
	public Passport(byte version, String id, String subId, String partitionId, String cardId) {
		super();
		this.version = version;
		this.id = id;
		this.subId=subId==null?"":subId;
		this.partitionId=partitionId==null?"":partitionId;
		this.cardId=cardId==null?"":cardId;
		shopOwner= StringUtils.isNotBlank(id) && id.equals(subId);
	}
	public Passport(String id, String subId, String partitionId, String cardId)
	{
		this((byte)1,id,subId,partitionId,cardId);
	}

	public byte getVersion() {
		return version;
	}

	public void setVersion(byte version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getSubId() {
		return subId;
	}
	public String getPartitionId() {
		return partitionId;
	}

	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	

	public String toString() {
		byte[] data=(this.id+"|"+this.subId+"|"+partitionId+"|"+cardId+";"+System.currentTimeMillis()).getBytes();
		try {
			data=encode(data);
			byte[] rlt=new byte[data.length+1];
			rlt[0]=(byte)version;
			System.arraycopy(data, 0, rlt, 1, data.length);
			return Base16.encode(rlt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Passport fromString(String ppt) {
		if(ppt==null){
			return null;
		}
		byte[] data= Base16.decode(ppt);
		byte[] content=new byte[data.length-1];
		System.arraycopy(data, 1,content,0,content.length);
		int version=(int)data[0];
		switch(version)
		{
			case 1:
				return readPassport1(content);
				
		}
		return null;
	}

	private static Passport readPassport1(byte[] data)
	{
		String str=decodeString(data);
		
		if(str.indexOf(';')>0)
		{
			String content=str.substring(0, str.indexOf(';'));
			String[] result=StringUtils.splitPreserveAllTokens(content, '|');
			if(result.length==4){
				return new Passport(result[0],result[1],result[2],result[3]);
			}
		}
		return null;
	}
	public static final byte[] key=new byte[]{0x3f,0x7a,0x45,(byte)0xf8,(byte)0xd9,(byte)0xa8,(byte)0x19,0x63};
	private static String decodeString(byte[] data)
	{
		try {
			return new String(des(key,data,false));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	private static byte[] encode(byte[] data)
	{
		try {
			if(data.length%8!=0)
			{
				byte[] rlt=new byte[data.length/8*8+8];
				System.arraycopy(data, 0, rlt, 0, data.length);
				return des(key,rlt,true);
			}
			return des(key,data,true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] des(byte[] key, byte[] src, boolean encrypt)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES/ECB/NOPadding");
		DESKeySpec desKey = new DESKeySpec(key);
		SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance("DES");
		
		cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE,
				(Key) KeyFactory.generateSecret(desKey));
		return cipher.doFinal(src);
	}

	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}
	public boolean isShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(boolean shopOwner) {
		this.shopOwner = shopOwner;
	}
}

package com.tcl.utils;

/**
 * Created by wang on 2017-06-13.
 */
public class Base16 {
    public static String encode(byte[] src) {
        StringBuffer rlt = new StringBuffer();
        for (int i = 0; i < src.length; ++i) {
            int v = src[i] & 0xFF;
            if (v <= 15) {
                rlt.append("0");
            }
            rlt.append(Integer.toHexString(v));
        }
        return rlt.toString();
    }

    public static byte[] decode(String src) {
        byte[] rlt = new byte[src.length() / 2];
        for (int i = 0; i < src.length(); i += 2) {
            rlt[(i / 2)] = (byte) Integer.parseInt(src.substring(i, i + 2), 16);
        }
        return rlt;
    }
}

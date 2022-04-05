package com.tcl.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Kewell on 2017/9/29.
 */
/*public class Test {
    public static void main(String[] args) throws Exception{
        HttpClient httpClient = new HttpClient();
        httpClient.getHostConfiguration().setHost("http://114.55.224.100:8888/TPS_Services/services/");
        GetMethod method = new GetMethod("http://114.55.224.100:8888/TPS_Services/services/third/rest/third/getCustomerInfoList?key=1234");
        method.releaseConnection();
        httpClient.executeMethod(method);
        System.out.println(method.getResponseBodyAsString());
        String str = method.getResponseBodyAsString();
        JSONObject jsonObject = new JSONObject(str);
        System.out.println(jsonObject.get("Message").toString());
        JSONArray jsonArray = new JSONArray(jsonObject.get("Message").toString());
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonO = jsonArray.getJSONObject(i);
            String customerId = jsonO.getString("customerId");
            String customerName = jsonO.getString("customerName");
            String testCenter = jsonO.getString("testCenter");
            String address = jsonO.getString("address");
            System.out.println("客户号：" + customerId + "，客户名称：" + customerName + ",               机构号：" + testCenter + ",地址：" + address);
        }
    }
}*/

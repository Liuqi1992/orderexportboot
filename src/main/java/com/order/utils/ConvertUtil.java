package com.order.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Utility class to convert one object to another.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class ConvertUtil {
    private static final Log log = LogFactory.getLog(ConvertUtil.class);


    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private ConvertUtil() {

    }

    /**
     * Method to convert a ResourceBundle to a Map object.
     *
     * @param rb a given resource bundle
     * @return Map a populated map
     */
    public static Map<String, String> convertBundleToMap(ResourceBundle rb) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }

        return map;
    }

    /**
     * Convert a java.util.List of LabelValue objects to a LinkedHashMap.
     *
     * @param list the list to convert
     * @return the populated map with the label as the key
     */
    /*public static Map<String, String> convertListToMap(List<LabelValue> list) {
        Map<String, String> map = new LinkedHashMap<String, String>();

        for (LabelValue option : list) {
            map.put(option.getLabel(), option.getValue());
        }

        return map;
    }*/

    /**
     * Method to convert a ResourceBundle to a Properties object.
     *
     * @param rb a given resource bundle
     * @return Properties a populated properties object
     */
    public static Properties convertBundleToProperties(ResourceBundle rb) {
        Properties props = new Properties();

        for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements(); ) {
            String key = keys.nextElement();
            props.put(key, rb.getString(key));
        }

        return props;
    }

    /**
     * Convenience method used by tests to populate an object from a
     * ResourceBundle
     *
     * @param obj an initialized object
     * @param rb  a resource bundle
     * @return a populated object
     */
    public static Object populateObject(Object obj, ResourceBundle rb) {
        try {
            Map<String, String> map = convertBundleToMap(rb);
            BeanUtils.copyProperties(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred populating object: " + e.getMessage());
        }

        return obj;
    }

    public static String null2String(String s) {
        return s == null ? "" : s.trim();

    }

    public static String null2String(Object s) {
        return s == null ? "" : s.toString();

    }

    public static int getIntValue(String v) {
        return getIntValue(v, -1);
    }

    public static int getIntValue(String v, int def) {
        try {
            return Integer.parseInt(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static Long getLongValue(String v) {
        return getLongValue(v, -1l);
    }

    public static Long getLongValue(String v, Long def) {
        try {
            return Long.parseLong(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static Float getFloatValue(String v) {
        return getFloatValue(v, 0);
    }

    public static Float getFloatValue(String v, float def) {
        try {
            return Float.parseFloat(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static Double getDoubleValue(String v) {
        return getDoubleValue(v, 0);
    }

    public static Double getDoubleValue(String v, double def) {
        try {
            return Double.parseDouble(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static String getFormatDate(Date v) {
        return getFormatDate(v, "");

    }

    public static String getFormatDate(Date v, String format) {
        try {
            //if(v==null) v= new Date();
            if (format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            // simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.format(v);
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getFormatDateGMT(Date v, String format) {
        try {
            if (v == null) v = new Date();
            if (format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getFormatDate(Date v, int value) {
        try {
            if (v == null) v = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v);
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.add(Calendar.DAY_OF_MONTH, value);
            //??????????????????
            String date = sim.format(calendar.getTime());
            return sim.format(calendar.getTime());
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Lis????????????
     *
     * @param flag
     * @return
     */
    public static String getResultFlag(String flag) {
        String retFlag = "";
        try {
            if (flag.charAt(1) == 'A') {
                if (flag == null || flag.isEmpty())
                    return "";
                if (flag.charAt(0) == 'A') {
                    retFlag = "??????";
                } else if (flag.charAt(0) == 'B') {
                    retFlag = "???";
                } else if (flag.charAt(0) == 'C') {
                    retFlag = "???";
                } else {
                    retFlag = "??????";
                }
            }
            if(flag.charAt(1) == 'B') {
              if(flag.charAt(0)=='B'){
                    retFlag = "*";   //??????
                }else {
                    retFlag = "";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            retFlag = "??????";
        }
        return retFlag;
    }

    /**
     * ??????????????????
     *
     * @param flag
     * @return
     */
    public static String getPrintResultFlag(String flag) {
        String retFlag = "";
        try {
            if (flag.charAt(1) == 'A') {
                if (flag == null || flag.isEmpty())
                    return "";
                if (flag.charAt(0) == 'A') {
                    retFlag = " ";
                } else if (flag.charAt(0) == 'B') {
                    retFlag = "???";
                } else if (flag.charAt(0) == 'C') {
                    retFlag = "???";
                } else {
                    retFlag = " ";
                }
            } else if (flag.charAt(1) == 'B') {
                if (flag.charAt(0) == 'A') {
                    retFlag = "??????";
                } else if (flag.charAt(0) == 'B') {
                    retFlag = "??????";
                } else {
                    retFlag = " ";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            retFlag = " ";
        }
        return retFlag;
    }

    public static String getResultFlag2(String flag) {
        String retFlag = "";
        try {
            if (flag == null || flag.isEmpty())
                return "";
            if (flag.charAt(0) == 'A') {
                retFlag = "z         ";
            } else if (flag.charAt(0) == 'B') {
                retFlag = "g         ";
            } else if (flag.charAt(0) == 'C') {
                retFlag = "d         ";
            } else {
                retFlag = "z         ";
            }

        } catch (Exception e) {
            e.printStackTrace();
            retFlag = "";
        }
        return retFlag;
    }


    public static String getStayHospitalModelValue(int model) {
        String value = "";
        switch (model) {
            case 1:
                value = "??????";
                break;
            case 2:
                value = "??????";
                break;
            case 3:
                value = "??????";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }

    /**
     * ????????????
     */
    public static String milfloatFormat(String args) {
        String temp = args;
        String temp1 = "";
        if (!args.isEmpty()) {
            if (args.indexOf(".") == -1) {
                temp = args;
            } else {
                if (!args.substring(0, args.indexOf(".")).equals("")) {
                    temp = args.substring(0, args.indexOf("."));
                } else {
                    temp = "0";
                }
                temp1 = args.substring(args.indexOf(".") + 1);
            }
            double d = getDoubleValue(temp);
            DecimalFormat df = new DecimalFormat("###,###");
            if (args.indexOf(".") == -1) {
                temp1 = "" + df.format(d);
            } else {
                temp1 = "" + df.format(d) + "." + temp1;
            }
        }
        return temp1;
    }

    /*public static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if(entry.getValue() instanceof JSONArray){
                    map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
                }else{
                    map.put((String)entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }*/

    public static String getCompressImagePath(String path) {
        return path.replace("upload","compress");
    }

    public static String  getFirstDayOfMonth(){
     Calendar c = Calendar.getInstance();
     c.add(Calendar.MONTH, 0);
     c.set(Calendar.DAY_OF_MONTH,1);//?????????1???,?????????????????????????????????
     return getFormatDate(c.getTime(),"yyyy-MM-dd");
    }
    //???????????????????????????
    public static String getLastDayOfMonth(){
        //???????????????????????????
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(ca.getTime(),"yyyy-MM-dd");
    }
    /**
     * ???????????????????????????????????????
     * @param smdate ???????????????
     * @param bdate  ???????????????
     * @return ????????????
     * @throws ParseException
     */
    public static Integer daysBetween(Date smdate,Date bdate) throws ParseException
    {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            smdate=sdf.parse(sdf.format(smdate));
            bdate=sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);
            return Integer.parseInt(String.valueOf(between_days));
        }catch (Exception e){
            return null;
        }

    }

    /**
     * ???????????????????????????????????????
     * @param smdate ???????????????
     * @param bdate  ???????????????
     * @return ????????????
     * @throws ParseException
     */
    public static Integer minuteBetween(Date smdate,Date bdate)
    {
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            smdate=sdf.parse(sdf.format(smdate));
            bdate=sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*60);
            return Integer.parseInt(String.valueOf(between_days));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getSexDisplayName(int sex){
        if (sex==1) {
            return "???";
        }else if (sex==2) {
            return "???";
        }
        return "??????";
    }
    public static Date getString2Date(String strDate) {
        return getString2Date(strDate,"yyyy-MM-dd");
    }
    public static Date getString2Date(String strDate, String format) {
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(strDate);
        }
        catch(Exception e) {
            date = null;
        }
        return date;
    }

    /**
     * @param date ??? ??????
     * @param type ??? ???????????? y???m???d???
     * @param value ??? ??????????????? ??????????????????????????????
     * @return ??????????????????Date
     *
     */
    public static Date dateAdd(Date date, String  type, int value){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if ("d".equals(type)) {
                cal.add(Calendar.DAY_OF_YEAR, value);//????????????N???
            } else if ("m".equals(type)) {
                cal.add(Calendar.MONTH, value);//????????????N??????
            } else if ("y".equals(type)) {
                cal.add(Calendar.YEAR, value);//????????????N???
            }else if ("h".equals(type)) {
                cal.add(Calendar.HOUR, value);//??????
            }
            return cal.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String replaceUTF8Bom(String str) {
        return str.replace("\uFEFF", "");
    }

    public static String toHtml(String s) {
        s=StringReplace(s,"<br>",""+'\n');
        char c[] = s.toCharArray();
        char ch;
        int i = 0;
        StringBuffer buf = new StringBuffer();

        while (i < c.length) {
            ch = c[i++];

            //???????????? TD2432 ??????????????????????????????????????? ?????? 2005-11-11 (????????? ??????~),??????????????????????????????????????? by ben 2005-12-29
            if (ch == '\'')
                buf.append("\''");
            else if (ch == '<')
                buf.append("&lt;");
            else if (ch == '>')
                buf.append("&gt;");
                // ??????????????????????????????????????????
            else if (ch == '"')
                buf.append("&quot;");
            else if (ch == '\n')
                buf.append("<br>");
            else
                buf.append(ch);
        }
        return buf.toString();
    }

    public static String StringReplace(String sou, String s1, String s2) {
        sou = null2String(sou);
        s1 = null2String(s1);
        s2 = null2String(s2);
        try{
            sou = sou.replace(s1, s2);
        }catch(Exception e){
            System.out.println(e);//???????????????????????????????????????????????????
        }
        return sou;
    }

    public static String getSexValue(String sex) {
        if("1".equals(sex)){
            return "???";
        }
        if("2".equals(sex)){
            return "???";
        }
        return sex;
    }

    public static String setVisitMode(String visitMode) {
        if("1".equals(visitMode)){
            return "??????";
        }
        if("2".equals(visitMode)){
            return "??????";
        }
        if("3".equals(visitMode)){
            return "??????";
        }
        return visitMode;
    }

    /**
     * excel?????????
     * @param
     * @return
     */
    /*public static String null2StringCell(Cell cell){
        if("".equals(ConvertUtil.null2String(cell))){
            return "";
        }else{
            cell.setCellType(Cell.CELL_TYPE_STRING);
            return cell.getStringCellValue();
        }

    }*/


}

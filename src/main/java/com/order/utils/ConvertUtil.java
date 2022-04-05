package com.order.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

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
            //进行时间转换
            String date = sim.format(calendar.getTime());
            return sim.format(calendar.getTime());
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Lis结果标记
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
                    retFlag = "正常";
                } else if (flag.charAt(0) == 'B') {
                    retFlag = "↑";
                } else if (flag.charAt(0) == 'C') {
                    retFlag = "↓";
                } else {
                    retFlag = "正常";
                }
            }
            if(flag.charAt(1) == 'B') {
              if(flag.charAt(0)=='B'){
                    retFlag = "*";   //阳性
                }else {
                    retFlag = "";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            retFlag = "正常";
        }
        return retFlag;
    }

    /**
     * 打印结果标记
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
                    retFlag = "↑";
                } else if (flag.charAt(0) == 'C') {
                    retFlag = "↓";
                } else {
                    retFlag = " ";
                }
            } else if (flag.charAt(1) == 'B') {
                if (flag.charAt(0) == 'A') {
                    retFlag = "阴性";
                } else if (flag.charAt(0) == 'B') {
                    retFlag = "阳性";
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
                value = "门诊";
                break;
            case 2:
                value = "病房";
                break;
            case 3:
                value = "体检";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }

    /**
     * 加千分为
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
     c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
     return getFormatDate(c.getTime(),"yyyy-MM-dd");
    }
    //获取当前月第一天：
    public static String getLastDayOfMonth(){
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(ca.getTime(),"yyyy-MM-dd");
    }
    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
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
     * 计算两个日期之间相差的分钟
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
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
            return "男";
        }else if (sex==2) {
            return "女";
        }
        return "未知";
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
     * @param date – 日期
     * @param type – 加减类型 y年m月d日
     * @param value – 加上的数值 如果为负数，则为减去
     * @return 返回增加后的Date
     *
     */
    public static Date dateAdd(Date date, String  type, int value){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if ("d".equals(type)) {
                cal.add(Calendar.DAY_OF_YEAR, value);//日期加减N天
            } else if ("m".equals(type)) {
                cal.add(Calendar.MONTH, value);//日期加减N个月
            } else if ("y".equals(type)) {
                cal.add(Calendar.YEAR, value);//日期加减N年
            }else if ("h".equals(type)) {
                cal.add(Calendar.HOUR, value);//小时
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

            //以下注释 TD2432 关于字段中含有单引号的问题 董平 2005-11-11 (光棍节 呵呵~),重新加入，处理插入数据插入 by ben 2005-12-29
            if (ch == '\'')
                buf.append("\''");
            else if (ch == '<')
                buf.append("&lt;");
            else if (ch == '>')
                buf.append("&gt;");
                // 刘煜增加针对英文双引号的处理
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
            System.out.println(e);//将未知异常打印出来，便于检查错误。
        }
        return sou;
    }

    public static String getSexValue(String sex) {
        if("1".equals(sex)){
            return "男";
        }
        if("2".equals(sex)){
            return "女";
        }
        return sex;
    }

    public static String setVisitMode(String visitMode) {
        if("1".equals(visitMode)){
            return "门诊";
        }
        if("2".equals(visitMode)){
            return "病房";
        }
        if("3".equals(visitMode)){
            return "体检";
        }
        return visitMode;
    }

    /**
     * excel空处理
     * @param cell
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

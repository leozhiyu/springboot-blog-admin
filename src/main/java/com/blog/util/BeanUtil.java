package com.blog.util;


import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yukong
 * @date: 2018/6/8 11:09
 * @description:
 */
public class BeanUtil {

    private static final String INTEGER = "java.lang.Integer";
    private static final String LONG = "java.lang.Long";

    /**
     * List<Map>转List<bean>
     *
     * @param list
     * @param clazz
     */
    public static List transMap2Bean(List<Map<String, Object>> list, Class clazz) {
        List result = new ArrayList();
        list.forEach(e->result.add(transMap2Bean(e,clazz)));
        return result;
    }

    /**
     * Map转bean
     *
     * @param map
     * @param clazz
     */
    public static Object transMap2Bean(Map<String, Object> map, Class clazz) {

        if (map == null) {
            return null;

        }

        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        java.lang.reflect.Field[] fields = obj.getClass().getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            int mod = field.getModifiers();
            //越过静态与final
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            try {
                Object value = map.get(camel2Underline(field.getName()).toLowerCase());
                if (value instanceof BigInteger) {
                    String fieldType = field.getGenericType().getTypeName();
                    if(LONG.equals(fieldType)) {
                        Long val = ((BigInteger) value).longValue();
                        field.set(obj, val);
                    }
                    if(INTEGER.equals(fieldType)){
                        Integer val = ((BigInteger) value).intValue();
                        field.set(obj, val);
                    }

                } else {
                    field.set(obj, value);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return obj;

    }

    /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }
}

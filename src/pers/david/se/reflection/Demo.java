package pers.david.se.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

    /**
     * @param o
     * @return
     * @Title: getFiledName
     * @Description: 获取属性名的数组
     * @author author
     * @date 2020-05-19 10:57:33
     */
    private String[] getFiledName(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * @param fieldName
     * @param o
     * @return
     * @Title: getFieldValueByName
     * @Description: 根据属性名获取属性值
     * @author bdawei@linewell.com
     * @date 2020-05-19 11:05:24
     */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}

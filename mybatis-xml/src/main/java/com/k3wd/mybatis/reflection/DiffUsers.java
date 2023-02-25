package com.k3wd.mybatis.reflection;

import com.k3wd.mybatis.model.Users;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author k3wd
 * @date 2023/2/24
 */
public class DiffUsers {
    public static void main(String[] args) throws IllegalAccessException {
        Map<String, String> equals = equals(new Users(), new Users());
    }

    public static Map<String, String> equals(Object o1, Object o2) throws IllegalAccessException {
        // 有差异的字段
        Map<String, String> diffMap = new HashMap<>();
        if (o1 == o2) {
            return diffMap;
        }
        Class o1Class = o1.getClass();
        Class o2Class = o2.getClass();
        if (o1Class.equals(o2Class)) {
            // 属于一个类，比较所有属性
            Field[] fields = o1Class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object oldValue = field.get(o1);
                Object newValue = field.get(o2);
                if ((oldValue == null && newValue != null) || newValue != null && !newValue.equals(oldValue)) {
                    diffMap.put(field.getName(), "from " + oldValue + " to " + newValue);
                }
            }
        }
        return diffMap;

    }
}

package com.landlord.utils;

import java.lang.reflect.Field;

public class FieldCopyUtil {
    public static void setFields(Object from, Object to) {
        Field[] fields = from.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Field fieldFrom = from.getClass().getField(field.getName());
                Object value = fieldFrom.get(from);
                to.getClass().getDeclaredField(field.getName()).set(to, value);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
            }
        }
    }
}
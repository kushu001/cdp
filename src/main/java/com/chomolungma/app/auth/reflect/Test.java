package com.chomolungma.app.auth.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {


    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Class clazz = MyReflect.class;

        Field[] fields = clazz.getDeclaredFields();

        Field gender = clazz.getDeclaredField("gender");

        MyReflect myReflect = new MyReflect();
        for (Field field: fields) {
            field.setAccessible(true);
            field.set(myReflect,field.getName());
            System.out.println(field.get(myReflect));

        }

        Method[] methods = clazz.getDeclaredMethods();
        Method.setAccessible(methods,true);
        for (Method method: methods) {

            if (method.getName().contains("get")){
                System.out.println(method.getName());

                Object value = method.invoke(myReflect,null);
                System.out.println(value);
            }
        }
    }
}

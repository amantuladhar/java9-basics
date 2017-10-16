package com.usertwo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// This class cannot use reflection API for com.exporter.Exported
public class UserTwo {
    public static void main(String[] args) throws Exception{
        Class<?> exportedClass = Class.forName("com.exported.Exported");
        Constructor<?> con = exportedClass.getDeclaredConstructor();
        con.setAccessible(true);
        Object exportedObj = con.newInstance();

        Method m;

        m = exportedObj.getClass().getMethod("callMe");
        m.setAccessible(true);
        System.out.println("Public : " + m.invoke(exportedObj));

        m = exportedObj.getClass().getDeclaredMethod("callMePrivate");
        m.setAccessible(true);
        System.out.println("Private : " + m.invoke(exportedObj));
    }
}
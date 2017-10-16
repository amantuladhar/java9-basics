package com.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class User {
    public static void main(String[] args) throws Exception{
    
        Class<?> myinternalBClass = Class.forName("com.exporter.Exported");
        Constructor<?> con = myinternalBClass.getDeclaredConstructor();
        con.setAccessible(true);
        Object myinternalB = con.newInstance();

        Method m;

        m = myinternalB.getClass().getMethod("callMe");
        m.setAccessible(true);
        m.invoke(myinternalB);
    }
}
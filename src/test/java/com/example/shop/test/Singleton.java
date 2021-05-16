package com.example.shop.test;

import com.example.shop.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton newInstance() {
        if (singleton == null) {
            synchronized (Class.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    public void test() throws Exception {
        User user = null;
        Class<User> clazz = User.class;
        user = clazz.getConstructor().newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);

        name.set(user, "123");
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        String name1 = setName.getName();
        setName.invoke(String.class, "123");

    }

}
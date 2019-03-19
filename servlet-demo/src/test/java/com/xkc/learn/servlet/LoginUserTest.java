package com.xkc.learn.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class LoginUserTest {
    private LoginUser loginUser;

    @Test
    public void testBeanUtils() {
        loginUser = new LoginUser();

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("username", "XKC");
        map.put("password", "189546");

        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(loginUser);
    }

    @Test
    public void testBeanUtilsProperty() {
        loginUser = new LoginUser();

        try {
            BeanUtils.setProperty(loginUser, "username", "XKC");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            BeanUtils.setProperty(loginUser, "password", "189546");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(loginUser);
    }


}

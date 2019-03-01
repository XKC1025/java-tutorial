package com.xkc.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatorTest {
    private Calculator clac = new Calculator();

    @Before
    public void before() {
        Date now = new Date(System.currentTimeMillis());

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("==========================开始时间" + format.format(now) + "=====================================");

    }

    @After
    public void after() {
        Date now = new Date(System.currentTimeMillis());

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("==========================结束时间" + format.format(now) + "=====================================");
    }

    @Test
    public void testAdd() {
        int result = clac.add(1, 3);
        // 断言
        Assert.assertEquals(4, result);

        System.out.println("add method");
    }

    @Test
    public void testSub() {
        int result = clac.sub(1, 3);
        Assert.assertEquals(-2, result);
    }
}

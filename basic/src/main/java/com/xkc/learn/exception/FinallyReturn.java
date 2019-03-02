package com.xkc.learn.exception;

/**
 * catch语句中的return会覆盖try语句中的return值
 * finally语句中的return会覆盖try和catch语句中的值
 *
 * finally中的代码一定会执行
 */
public class FinallyReturn {
    private static int getResult() {
        try {
            return 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 20;
        } finally {
            return 30;
        }
    }

    public static void main(String[] args) {
        int result = getResult();

        System.out.println(result);
    }
}

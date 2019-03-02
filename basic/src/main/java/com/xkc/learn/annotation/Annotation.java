package com.xkc.learn.annotation;

import static com.xkc.learn.enums.Person.P1;

/**
 * 注解的演示
 *
 * @author xukechen
 * @version 1.0
 * @since 1.5
 */
@SuppressWarnings("all")
public class Annotation {
    @MyAnno3("XKC")
    private String name;
    /**
     * 计算两数的和
     *
     * @return sum
     */
    @MyAnno2("value")
    public int add() {
        return 10;
    }

    @MyAnno(show = "show", age = 22, p = P1, strs={"XU", "KE", "CHEN"}, anno = @MyAnno2("value"))
    public int sub() {
        return 0;
    }

    @MyAnno3
    public static void method() {

    }
    public static void main(String[] args) {

    }
}

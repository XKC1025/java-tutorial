package com.xkc.learn.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 元注解:
 * 	    用于描述注解的注解
 *  @Target:
 * 		描述注解能够作用的位置
 * 	    ElementType[] value()
 *
 * 	@Retention:
 * 		描述注解被保留的阶段
 * 	    SOURCE: 源代码阶段有, 编译过后 没有     @Override注解
 * 	    CLASS: 源代码, class文件有, JVM不可读取
 * 	    RUNTIME: 源代码, class文件, JVM可读取  自定义注解
 *
 * 	@Documented:
 * 		描述此注解是否被抽取到API文档中, 默认不抽取
 *
 * 	@Inherited:
 * 		描述此注解是否能被子类继承, 默认不继承
 */


@Target(value = {TYPE, FIELD, METHOD})
@Retention(value = RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
    String value() default "";
}

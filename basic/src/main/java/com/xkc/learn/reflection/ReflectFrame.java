package com.xkc.learn.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架原理:
 *      不改变框架的任何代码, 就可以创建任意对象, 执行其中的任意方法
 *
 * 实现:
 *      1.配置文件
 *      2.反射
 */

@MyBean(className="com.xkc.learn.reflection.Person", methodName="sayHello")
@SuppressWarnings({"all"})
public class ReflectFrame {
    private static void byProperties() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 加载配置文件
        Properties properties = new Properties();

        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectFrame.class.getClassLoader();

        // 通过类加载器获得字节输入流
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        // 获取配置文件中的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 利用反射创建对象
        Class clazz = Class.forName(className);

        Object o = clazz.newInstance();

        Method method = clazz.getMethod(methodName, String.class);

        Object xkc = method.invoke(o, "XKC");
    }

    private static void byAnno() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = ReflectFrame.class;

        // 在内存中创建了MyBean注解接口的子类实例
        MyBean annotation = (MyBean)clazz.getAnnotation(MyBean.class);

        if (annotation != null ) {
            String className = annotation.className();
            String methodName = annotation.methodName();

            // 创建对象
            Class aClass = Class.forName(className);
            Object o = aClass.newInstance();

            Method method = aClass.getMethod(methodName, String.class);

            method.invoke(o, "Xu kechcen");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // byProperties();

        byAnno();
    }
}

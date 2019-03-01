package com.xkc.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectObj {
    // 获取Class对象
    // Class.class   Obj.getClass()  Class.forName("ClassName")
    private static Class clazz = Person.class;

    private static void fields() throws NoSuchFieldException, IllegalAccessException {
        // 获取public字段对象
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        // 根据字段名获取public字段对象, 其他修饰词都不能获取
        Field field = clazz.getField("addr");
        System.out.println(field.getName());

        // Field.get()获取值
        Person xkc = new Person("XKC", 22);
        System.out.println(field.get(xkc));
        // Field.set()赋值
        field.set(xkc, "Xu zhou");
        System.out.println(field.get(xkc));
        System.out.println(xkc);

        // 获取全部字段对象
        Field[] fields1 = clazz.getDeclaredFields();
        Arrays.stream(fields1).forEach(System.out::println);

        // 将private字段设置成public字段
        Field name = fields[0];
        name.setAccessible(true);
        name.set(xkc, "xu ke chen");
        System.out.println(xkc);

        // 获取指定字段对象, 不管任何修饰词均可获取
        Field field1 = clazz.getDeclaredField("salary");
        System.out.println(field1.getName());
    }

    @SuppressWarnings({"unchecked"})
    private static void constructors() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取public构造方法
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));

        // 获取指定public构造方法
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        // 获取全部构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // 获取指定构造方法
        Constructor declaredConstructor = clazz.getDeclaredConstructor(double.class, String.class);
        System.out.println(declaredConstructor);

        // 使用构造方法对象创建实例对象
        declaredConstructor.setAccessible(true);
        Person person = (Person) declaredConstructor.newInstance(10000D, "Nanjing");
        System.out.println(person);

        // 获取空参构造器
        Constructor constructor1 = clazz.getConstructor();
        // 调用空参构造器创建对象
        Object o = constructor1.newInstance();
        // 等价于Class.newInstance()
        Object o1 = clazz.newInstance();
        System.out.println(o);
        System.out.println(o1);

    }

    private static void methods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取全部public方法, 包括继承父类的public方法, 不包括父类中被重写的方法
        Method[] methods = clazz.getMethods();
        System.out.println(Arrays.toString(methods));

        // 获取全部的方法, 不包括继承父类的任何方法
        Method[] methods1 = clazz.getDeclaredMethods();
        System.out.println(Arrays.toString(methods1));

        // 获取指定public方法, 也可以获取继承的父类方法
        Method method = clazz.getMethod("getClass");
        System.out.println(method);

        // 获取指定方法, 不能获取父类的任何方法
        Method method1 = clazz.getDeclaredMethod("sayGood", String.class);
        System.out.println(method1);

        // 执行方法
        method1.setAccessible(true);
        Person person = new Person("XKC", 22);
        method1.invoke(person, "night");


    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        fields();

        constructors();

        methods();
    }
}

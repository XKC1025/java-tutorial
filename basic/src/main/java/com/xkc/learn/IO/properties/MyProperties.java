package com.xkc.learn.IO.properties;

import java.io.*;
import java.util.Properties;

/**
 * 属性集合:
 * 继承Hashtable, 唯一和IO流相结合的集合 load(Reader reader) 和 store(Writer writer, String comments)
 * K-V结构, 都是字符串
 * System.getProperties()  获取的就是Properties对象
 * <p>
 * 1.来读取K-V结构的配置文件
 * 2.持久化集合中的数据到硬盘
 */
public class MyProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();

        // 设置属性
        properties.setProperty("Email", "898044807@qq.com");

        // 用类加载器获取配置文件
        InputStream resourceAsStream = MyProperties.class.getResourceAsStream("config.properties");

        // 把系统环境变量信息保存进配置文件
//        properties.store(new FileOutputStream(new File("/home/xukechen/JavaEE/workspace/java-tutorial/basic/src/main/java/com/xkc/learn/resources/config.properties")), "System environment variables");

        // 读取配置文件信息
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("user.name"));
        System.out.println(properties.getProperty("Email"));

        // 遍历properties
        for (String string : properties.stringPropertyNames()) {
            System.out.println(properties.getProperty(string));
        }
    }
}

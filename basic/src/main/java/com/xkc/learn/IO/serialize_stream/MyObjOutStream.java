package com.xkc.learn.IO.serialize_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化流
 */
public class MyObjOutStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/serialize_stream/object.txt"));

        // 写对象
        objectOutputStream.writeObject(new Student("Xu ke chen", 22));

        objectOutputStream.close();
    }
}

class Student implements Serializable {
    // 手动指定序列化UID
    static final long serialVersionUID = 23456L;

    private String name;
    public int age;

    // 静态不能被序列化
    static String girlFriend = "小美女";

    // 瞬态关键字, 不能被序列化
    transient String grade = "Senior";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.xkc.learn.IO.serialize_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象的反序列化
 *      序列化之后, 原class文件不可以修改, 否则会报InvalidClassException
 *
 *      手动指定serialVersionUID, 显示声明修改文件就不会报错
 */
public class MyObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("basic/src/main/java/com/xkc/learn/IO/serialize_stream/object.txt"));

        Object o = objectInputStream.readObject();

        Student student = (Student)o;

        System.out.println(Student.girlFriend);
        System.out.println(student.grade);

        objectInputStream.close();
    }
}

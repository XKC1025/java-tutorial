package com.xkc.learn.IO.serialize_stream;

import java.io.*;
import java.util.ArrayList;

/**
 * 序列化集合
 */
public class SerializeCollection {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("X", 22));
        students.add(new Student("XK", 23));
        students.add(new Student("XKC", 24));
        students.add(new Student("Xu ke chen", 24));

        Object[] stuArr = students.toArray();

        // 对集合进行序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basic/src/main/java/com/xkc/learn/IO/serialize_stream/list.txt"));
        oos.writeObject(stuArr);

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("basic/src/main/java/com/xkc/learn/IO/serialize_stream/object.txt"));
        Object o = ois.readObject();

//        Student[] list2 = (Student[]) o;

        oos.close();
        ois.close();
    }
}

package com.xkc.learn.IO.file;

import java.io.File;

/**
 * 筛选文件夹, 以及.java结尾的文件
 */
public class MyFileFilter {
    // /home/xukechen/JavaEE/workspace/basic-simple

    public static void main(String[] args) {
        String path = "/home/xukechen/JavaEE/workspace/basic-simple";

        filter(path);
    }

    private static void filter(String path) {
        File root = new File(path);

        // lambda表达式, 就是筛选规则
        File[] files = root.listFiles((dir, name) -> new File(dir, name).isDirectory() || name.toLowerCase().endsWith("java"));

        for (File file : files) {
            if (file.isDirectory()) {
                String newPath = path + "/" + file.getName();

                filter(newPath);
            }

            System.out.println(file.getName());
        }
    }
}

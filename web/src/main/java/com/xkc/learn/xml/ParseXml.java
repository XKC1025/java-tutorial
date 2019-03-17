package com.xkc.learn.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 解析XML文件
 */
public class ParseXml {
    public static void main(String[] args) throws IOException {
        String path = Objects.requireNonNull(ParseXml.class.getClassLoader().getResource("config.xml")).getPath();

        // 获取document对象
        Document dom = Jsoup.parse(new File(path), "utf-8");

        // 获取元素对象
        Elements dependency = dom.getElementsByTag("dependency");

        System.out.println(dependency.size());

        System.out.println(dependency.get(0).text());
    }
}

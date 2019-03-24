package com.xkc.learn.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xkc.learn.json.domain.Person;
import org.junit.Test;
import java.io.IOException;
import java.util.*;

/**
 * Java对象与JSON互相转化:
 * 1.创建Jackson核心对象ObjectMapper
 * 2.调用ObjectMapper方法进行转化
 *
 *
 * 注解:
 * 1.@JsonIgnore 排除属性
 * 2.@JsonFormat 属性格式化
 *
 * 集合的转换
 *      List Map
 */
public class MyJackson {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testObj2Json() throws JsonProcessingException {
        Person person = new Person("X", 22, "male", new Date());

        // 对象转成String
        String string = objectMapper.writeValueAsString(person);

        System.out.println(string);

        // 将JSON对象写到文件中
        // objectMapper.writeValue(new File(), person1);

    }

    @Test
    public void testAnno() throws JsonProcessingException {
        Person person = new Person("X", 22, "male", new Date());

        String string = objectMapper.writeValueAsString(person);

        System.out.println(string);
    }

    @Test
    public void testCollection() throws JsonProcessingException {
        Person person1 = new Person("X", 22, "male", new Date());
        Person person2 = new Person("XK", 23, "male", new Date());
        Person person3 = new Person("XKC", 24, "male", new Date());

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        String string = objectMapper.writeValueAsString(personList);
        System.out.println(string);

        Map<Integer, Person> map  = new HashMap<>();
        map.put(1, person1);
        map.put(2, person2);
        map.put(3, person3);

        String string1 = objectMapper.writeValueAsString(map);
        System.out.println(string1);

        List<Map<Integer, Person>> mapList = new LinkedList<>();
        mapList.add(map);

        String string2 = objectMapper.writeValueAsString(mapList);
        System.out.println(string2);
    }

    @Test
    public void testJson2Obj() throws IOException {
        Person person = new Person("X", 22, "male", new Date());

        String string = objectMapper.writeValueAsString(person);

        // Json转成Java对象
        Person person1 = objectMapper.readValue(string, Person.class);

        System.out.println(person1);
    }
}

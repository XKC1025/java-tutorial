package com.xkc.learn.controller;

import com.xkc.learn.req.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * @RequestBody 将JSON数据封装成POJO对象
     * @param student
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Student student) {
        System.out.println(student);
    }

    /**
     * @ResponseBody 将对象转成JSON格式返回
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Student get() {
        Student student = new Student();

        student.setName("XKC");
        student.setAge(22);
        student.setSex("male");

        return student;
    }

    /**
     * 获取xml格式数据
     * @return
     */
    @RequestMapping(value = "/getXml", method = RequestMethod.GET, produces={"application/xml; charset=UTF-8"})
    public Student getXml() {
        Student student = new Student();

        student.setName("XKC");
        student.setAge(22);
        student.setSex("male");

        System.out.println("Return XML");
        return student;
    }
}

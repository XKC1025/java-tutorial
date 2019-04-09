package com.xkc.learn.controller;

import com.xkc.learn.req.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController3 {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "/user/userlist";
    }

    @RequestMapping(value = "/register/{username}", method = RequestMethod.GET)
    public void register(@PathVariable("username") String username, String password) {
        System.out.println(username);
    }

    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public void register2(String username, String password, Date date) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(date);
    }

    @RequestMapping(value = "/register3", method = RequestMethod.POST)
    public void register3(User user) {
        System.out.println(user);
    }
}

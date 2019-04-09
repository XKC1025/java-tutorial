package com.xkc.learn.controller;

import com.xkc.learn.req.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController3 {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println(model.getClass());
        System.out.println(this);
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
        System.out.println(this);
    }

    /**
     * @RequestParam参数描述
     *  value: 参数名称
     *  default: 默认值
     *  required: 是否必须有值
     *
     * @param
     */
    @RequestMapping(value = "/register4", method = RequestMethod.GET)
    public void register4(@RequestParam(value = "uid", defaultValue = "1", required = true) Integer uid) {
        System.out.println(uid);
        System.out.println(this);
    }
}

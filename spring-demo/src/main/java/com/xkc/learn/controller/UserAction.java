package com.xkc.learn.controller;

import com.xkc.learn.domain.User;
import com.xkc.learn.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")    // 开启多例
public class UserAction {

    // @Autowired
    // @Qualifier("myService")
    @Resource(name = "myService")  // 等效上面两行代码
    private IUserService iUserService;

    public void addUser(User user) {
        System.out.println("controller 添加用户: " + user);
        iUserService.addUser(user);
    }
}

package cn.itcast.controller;

import cn.itcast.exception.Sysexception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class Usercontroller {
    @RequestMapping("/testexpection")
    public String testexpection() throws Sysexception {
        System.out.println("testexpection");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            throw new Sysexception("查询所有用户出错了");
        }
        return "success";
    }

    @RequestMapping("/testinterceptors")
    public String testinterceptors() {
        System.out.println("testinterceptors");
        return "success";
    }
}
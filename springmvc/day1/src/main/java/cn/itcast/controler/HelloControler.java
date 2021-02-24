package cn.itcast.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HelloControler {
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello springmvc");
        return "success";
    }

    /**
     * value
     * method
     * params
     * @return
     */
    @RequestMapping(path = "/RequestMapping", headers = {"Accpt"})
    public String testRequestMapping() {
        System.out.println("test RequestMapping");
        return "success";
    }
}

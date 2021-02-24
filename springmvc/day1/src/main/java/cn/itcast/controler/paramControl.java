package cn.itcast.controler;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class paramControl {
    @RequestMapping(path = "/testparam")
    public String testparam(String username, String password) {
        System.out.println("param");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping(path = "/saveaccount")
    public String testparam(Account account) {
        System.out.println("param");
        System.out.println(account);
        return "success";
    }
    @RequestMapping(path = "/saveuser")
    public String testparam(User user) {
        System.out.println("param");
        System.out.println(user);
        return "success";
    }
    @RequestMapping(path = "/testserletAPI")
    public String testserletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了testserletAPI");
        System.out.println(request);
        HttpSession session=request.getSession();
        System.out.println(session);
        ServletContext servletContext=session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }
}

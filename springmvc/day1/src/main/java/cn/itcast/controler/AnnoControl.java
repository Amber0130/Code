package cn.itcast.controler;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "yyy")
public class AnnoControl {
    @RequestMapping("/testrequstparam")
    public String testrequstparam(@RequestParam(name = "name") String username) {
        System.out.println("testrequstparam");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testrequestbody")
    public String testrequestbody(@RequestBody String body) {
        System.out.println("testrequstparam");
        System.out.println(body);
        return "success";
    }

    @ModelAttribute
    @RequestMapping("/testrePathVariable/{uid}")
    public String testrePathVariable(User user) {
        System.out.println("testrequstparam");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testRequestHeader/{uid}")
    public String testRequestHeader(@RequestHeader(value = "Accept") String id) {
        System.out.println("testrequstparam");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testCookieValue/{uid}")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testrequstparam");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("123") User user) {
        System.out.println(user);
        return "success";
    }

    //    @ModelAttribute
//    public void showuser() {
//        System.out.println("123");
//    }
    @ModelAttribute
    public void showuser(String uname, Map<String, User> map) {
        User user = new User();
        user.setDate(new Date());
        user.setUname(uname);
        user.setAge(10);
        map.put("123", user);
    }
    @RequestMapping(path = "/testSessionAttribute")
    public String testSessionAttribute(Model model) {
        System.out.println("testSessionAttribute");
        model.addAttribute("yyy","666");
        return "success";
    }
    @RequestMapping(path = "/getSessionAttribute")
    public String getSessionAttribute(ModelMap model) {
        System.out.println("getSessionAttribute");
        String s= (String) model.get("yyy");
        System.out.println(s);
        return "success";
    }
    @RequestMapping(path = "/delSessionAttribute")
    public String delSessionAttribute(SessionStatus status) {
        System.out.println("getSessionAttribute");
        status.setComplete();
        return "success";
    }
}

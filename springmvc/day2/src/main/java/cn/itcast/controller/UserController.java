package cn.itcast.controller;
import cn.itcast.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String test(Model model) {
        System.out.println("test执行了");
        User user = new User();
        user.setAge(16);
        user.setUsername("zhang");
        user.setPassword("123456");
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("test执行了");
        //转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return;
    }

    @RequestMapping("/testforwardorRedirect")
    public String testforwardorRedirect() {
        System.out.println("testforwardorRedirect执行了");
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView执行了");
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setAge(16);
        user.setUsername("zhang");
        user.setPassword("123456");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testajax")
    public @ResponseBody
    User testajax(@RequestBody User user) {
        System.out.println("testajax");
        System.out.println(user);
        user.setAge(66);
        user.setUsername("hhhh");
        return user;
    }

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request) throws Exception {
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        // 创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        // 遍历
        for (FileItem fileItem : list) {
            // 判断文件项是普通字段，还是上传的文件
            if (fileItem.isFormField()) {
            } else {
                // 上传文件项
                String filename = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 上传文件
                fileItem.write(new File(file, filename));
                // 删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 上传文件
        upload.transferTo(new File(path, filename));
        return "success";
    }

    @RequestMapping(value = "/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        //定义上传服务器的路径
        String path = "http://localhost:9090/uploads/";

        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 上传文件

        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        resource.put(upload.getBytes());
        return "success";
    }
}
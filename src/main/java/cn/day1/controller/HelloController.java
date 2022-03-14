package cn.day1.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/2/7 10:57 下午
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @RequiresAuthentication
    public String hello() {
        System.out.println("hahhah");
        return "hahahahah";
    }

    @RequiresRoles("ADMIN")
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequiresRoles("TEACHER")
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher";
    }

    @RequiresRoles("STUDENT")
    @RequestMapping("/student")
    public String student() {
        return "student";
    }

}

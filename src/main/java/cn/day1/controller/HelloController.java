package cn.day1.controller;

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
    public String hello() {

        return "hahahahah";
    }

}

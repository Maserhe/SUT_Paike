package cn.day1;

import com.cxytiandi.encrypt.springboot.annotation.EnableEncrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 * 启动类
 *
 * @author maserhe
 * @date 2022/2/7 10:46 下午
 **/

@SpringBootApplication
@ComponentScan
public class StartApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartApplication.class, args);
    }
}

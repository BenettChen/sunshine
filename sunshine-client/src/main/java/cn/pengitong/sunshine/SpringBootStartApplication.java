package cn.pengitong.sunshine;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeng
 * 在启动类中添加对 mapper 包扫描@MapperScan
 */
@MapperScan("cn.pengitong.sunshine.persist")
@ComponentScan({"cn.pengitong.sunshine.service", "cn.pengitong.sunshine.client"})
@RestController
@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootStartApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "success";
    }
}

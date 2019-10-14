package cn.pengitong.sunshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenpeng
 */
@SpringBootApplication
@MapperScan("cn.pengitong.sunshine.mapper")
public class SunshineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunshineApplication.class, args);
    }

}

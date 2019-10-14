package cn.pengitong.sunshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author chenpeng
 * 在启动类中添加对 mapper 包扫描@MapperScan
 */
@MapperScan("cn.pengitong.sunshine.mapper")
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SunshineApplication.class);
    }
}

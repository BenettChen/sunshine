package cn.pengitong.sunshine.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestController {

	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot";
	}

}
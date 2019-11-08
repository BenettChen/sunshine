package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.service.ArticleContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenpeng
 */
@RestController
public class TestController {

    @Resource
    private ArticleContentService articleContentService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test success";
    }

	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot";
	}

	@RequestMapping(value = "/insert", method= RequestMethod.GET)
	public String insert(@RequestParam Integer contentId) {
		articleContentService.insert(contentId);
		return "success";
	}

	@RequestMapping("/showAll")
	public Object showAll() {
    	return articleContentService.showAll();
	}


}

package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.service.ArticleContentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author chenpeng
 */
@RestController
@RequestMapping("")
public class TestController {

    @Resource
    private ArticleContentService articleContentService;

    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public String testException() {
        int a = 3 / 0;
        return "sss";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test success";
    }

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

	@RequestMapping(value = "/article/{contentId}", method = RequestMethod.GET)
	@ResponseBody
    public Object insert2(@PathVariable("contentId") Integer contentId) {
		articleContentService.insert(contentId);
    	return "success";
	}

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@RequestParam Integer contentId) {
        articleContentService.insert(contentId);
        return "success";
    }

    @RequestMapping("/showAll")
    public Object showAll() {
        return articleContentService.showAll();
    }

    @GetMapping("/upload")
    public ModelAndView upload() {
        ModelAndView view = new ModelAndView("upload");
        return view;
    }

    @PostMapping("uploadFile")
    public Object uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/chenpeng/Desktop/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "上传失败！";
    }

}

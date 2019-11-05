package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
import cn.pengitong.sunshine.persist.dao.mapper.ArticleContentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunshineApplicationTests {

    @Resource
    private ArticleContentMapper articleContentMapper;

    @Test
    public void contextLoads() {
        List<ArticleContentDO> articleContentDOS = articleContentMapper.queryArticleContent();
        System.out.println(articleContentDOS);
    }

}

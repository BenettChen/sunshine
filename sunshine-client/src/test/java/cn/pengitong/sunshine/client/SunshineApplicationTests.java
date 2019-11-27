package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
import cn.pengitong.sunshine.persist.dao.mapper.ArticleContentMapper;
import cn.pengitong.sunshine.service.ArticleContentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunshineApplicationTests {

    @Resource
    private ArticleContentMapper articleContentMapper;

    @Resource
    private ArticleContentService articleContentService;

    @Test
    public void contextLoads() {
        List<ArticleContentDO> articleContentDOS = articleContentMapper.queryArticleContent();
        System.out.println(articleContentDOS);
    }

    @Test
    public void should_add_data_2_database_when_insert_data_given_one_entity() {
        Integer contentId = 102;

        try {
            articleContentService.insert(contentId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArticleContentDO result = articleContentMapper.queryArticleContentByContentId(contentId);
        Assert.assertNotNull(result);
    }

    private ArticleContentDO mockArticleContentDO(Integer contentId) {
        ArticleContentDO articleContentDO = new ArticleContentDO();
        articleContentDO.setArticleContent("文章内容" + contentId);
        articleContentDO.setContentId(contentId);
        articleContentDO.setGmtCreate(new Date());
        articleContentDO.setGmtModify(new Date());
        return articleContentDO;
    }

}

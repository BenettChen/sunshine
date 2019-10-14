package cn.pengitong.sunshine.service;

import cn.pengitong.sunshine.infrastructure.model.ArticleContentDO;
import cn.pengitong.sunshine.mapper.ArticleContentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: chen peng
 * @create: 2019-10-14
 * @description:
 **/
@Service
public class ArticleContentService {

    @Resource
    private ArticleContentMapper articleContentMapper;

    public void insert( ) {
        ArticleContentDO articleContentDO = new ArticleContentDO();
        articleContentDO.setArticleContent("文章内容");
        articleContentDO.setContentId(1);
        articleContentDO.setGmtCreate(new Date());
        articleContentDO.setGmtModify(new Date());
        articleContentMapper.insert(articleContentDO);
    }

}

package cn.pengitong.sunshine.service;

import org.springframework.stereotype.Service;
import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
import cn.pengitong.sunshine.persist.dao.mapper.ArticleContentMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: chen peng
 * @create: 2019-10-14
 * @description:
 **/
@Service
public class ArticleContentService {

    @Resource
    private ArticleContentMapper articleContentMapper;

    public void insert(Integer contentId) {
        ArticleContentDO articleContentDO = new ArticleContentDO();
        articleContentDO.setArticleContent("文章内容" + contentId);
        articleContentDO.setContentId(contentId);
        articleContentDO.setGmtCreate(new Date());
        articleContentDO.setGmtModify(new Date());
        articleContentMapper.insert(articleContentDO);
    }

    public List<ArticleContentDO> showAll() {
        List<ArticleContentDO> articleContentDOS = articleContentMapper.queryArticleContent();
        return articleContentDOS;
    }

}

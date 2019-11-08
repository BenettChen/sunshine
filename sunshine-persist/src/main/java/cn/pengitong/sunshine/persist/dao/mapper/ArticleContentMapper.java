package cn.pengitong.sunshine.persist.dao.mapper;

import cn.pengitong.sunshine.persist.dao.bean.ArticleContentDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenpeng
 */
@Mapper
public interface ArticleContentMapper {


    @Select("SELECT * FROM article_content WHERE content_id = #{id}")
    ArticleContentDO queryArticleContentByContentId(@Param("contentId") Integer contentId);

    @Select("SELECT * FROM article_content")
    List<ArticleContentDO> queryArticleContent();

    @Insert("INSERT INTO article_content(content_id,article_content,gmt_create,gmt_modify) VALUES(#{contentId}, #{articleContent}, #{gmtCreate}, #{gmtModify})")
    void insert(ArticleContentDO articleContent);


}

package cn.pengitong.sunshine.mapper;

import cn.pengitong.sunshine.infrastructure.model.ArticleContentDO;
import org.apache.ibatis.annotations.*;

/**
 * @author chenpeng
 */
@Mapper
public interface ArticleContentMapper {
    //    @Results({
//            @Result(property = "id",  column = "id"),
//            @Result(property = "articleContent", column = "article_content"),
//            @Result(property = "contentId", column = "content_id"),
//            @Result(property = "gmtCreate", column = "gmt_create"),
//            @Result(property = "gmtModify", column = "gmt_modify")
//    })

    @Select("SELECT * FROM article_content WHERE content_id = #{id}")
    ArticleContentDO queryArticleContentByContentId(@Param("contentId") Integer contentId);

    @Insert("INSERT INTO article_content(content_id,article_content,gmt_create,gmt_motdify) VALUES(#{contentId}, #{articleContent}, #{gmtCreate}, #{gmtModify})")
    void insert(ArticleContentDO articleContent);
}
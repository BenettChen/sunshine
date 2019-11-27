package cn.pengitong.sunshine.persist.dao.bean;


import lombok.Data;

/**
 * @author chenpeng
 */
@Data
public class ArticleContentDO extends BaseDO {
    private String articleContent;
    private Integer contentId;
}

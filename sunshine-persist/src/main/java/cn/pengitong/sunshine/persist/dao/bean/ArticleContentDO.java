package cn.pengitong.sunshine.persist.dao.bean;


import lombok.Data;

/**
 * @author chenpeng
 */
@Data
public class ArticleContentDO extends BaseDo {
    private String articleContent;
    private Integer contentId;
}

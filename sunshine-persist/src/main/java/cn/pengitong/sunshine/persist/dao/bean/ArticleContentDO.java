package cn.pengitong.sunshine.persist.dao.bean;


import lombok.Data;
import lombok.Setter;

import javax.persistence.Table;

/**
 * @author chenpeng
 */
@Data
@Table(name = "article_content")
public class ArticleContentDO extends BaseDO {
    private String articleContent;
    private Integer contentId;
}

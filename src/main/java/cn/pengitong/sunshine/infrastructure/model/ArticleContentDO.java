package cn.pengitong.sunshine.infrastructure.model;

import lombok.Data;

/**
 * @author chenpeng
 */
@Data
public class ArticleContentDO extends BeseDO {
    private String articleContent;
    private Integer contentId;
}

package cn.pengitong.sunshine.persist.dao.bean;


import lombok.Data;

import java.util.Date;

/**
 * @author chenpeng
 */
@Data
public class BaseDo {
    private Long id;
    private Date gmtCreate;
    private Date gmtModify;
}


package cn.pengitong.sunshine.persist.dao.bean;


import lombok.Data;

import java.util.Date;

/**
 * @author chenpeng
 */
@Data
public class BaseDO {
    private Date gmtCreate;
    private Date gmtModify;
}


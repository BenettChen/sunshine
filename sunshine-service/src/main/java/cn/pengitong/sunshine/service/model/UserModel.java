package cn.pengitong.sunshine.service.model;

import lombok.Data;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
@Data
public class UserModel {
    private Long id;
    private String account;
    private String name;
    private String pwd;
}

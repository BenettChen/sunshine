package cn.pengitong.sunshine.service.model;

import cn.pengitong.sunshine.service.myannotation.MyUser;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
@Data
@Component
public class UserModel {
    private Long id;
    private String account;
    @MyUser("我是陈鹏")
    private String name;
    private String pwd;
}

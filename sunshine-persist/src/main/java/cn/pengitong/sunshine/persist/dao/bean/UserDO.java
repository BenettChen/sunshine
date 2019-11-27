package cn.pengitong.sunshine.persist.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
@Entity
@Data
@AllArgsConstructor
@Table(name = "user")
public class UserDO {
    @Id
    private Long id;
    private String account;
    private String name;
    private String pwd;

    protected UserDO() {};
}

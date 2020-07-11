package cn.pengitong.sunshine.persist.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
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
    @PrimaryKeyJoinColumn
    private Long id;
    private String account;
    private String name;
    private String pwd;

    public UserDO(String account, String name, String pwd) {
        this.account = account;
        this.name = name;
        this.pwd = pwd;
    }

    protected UserDO() {};
}

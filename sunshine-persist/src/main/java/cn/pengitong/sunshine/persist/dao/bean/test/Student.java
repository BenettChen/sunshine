package cn.pengitong.sunshine.persist.dao.bean.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Student")
public class Student {
    public Student() {
    }

    @Id
    @PrimaryKeyJoinColumn
    private Integer Id;
    private String name;
}

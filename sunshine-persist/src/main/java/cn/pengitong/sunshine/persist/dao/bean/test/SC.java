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
@Table(name = "SC")
public class SC {
    @Id
    @PrimaryKeyJoinColumn
    private Integer scId;
    private Integer sId;
    private Integer cId;
    private Integer score;

    public SC() {
    }
}

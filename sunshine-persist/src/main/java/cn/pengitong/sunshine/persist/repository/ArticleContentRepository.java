package cn.pengitong.sunshine.persist.repository;

import cn.pengitong.sunshine.persist.dao.bean.UserDO;
import org.springframework.data.repository.Repository;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
public interface ArticleContentRepository extends Repository<UserDO, Long> {
    public UserDO save(UserDO userDO);
}

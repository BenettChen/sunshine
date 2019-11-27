package cn.pengitong.sunshine.persist.repository;

import cn.pengitong.sunshine.persist.dao.bean.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
public interface CrudUserRepository extends CrudRepository<UserDO, Long> {
}

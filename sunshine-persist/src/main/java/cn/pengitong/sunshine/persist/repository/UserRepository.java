package cn.pengitong.sunshine.persist.repository;

import cn.pengitong.sunshine.persist.dao.bean.UserDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
@RepositoryDefinition(domainClass = UserDO.class, idClass = Long.class)
public interface UserRepository {
    UserDO findUserDOById(Long id);

    @Query("select u from UserDO u where u.id = ?1")
    UserDO findUserDOByQuery(Long id);

    @Query(nativeQuery = true, value = "select * from user u where u.id = ?1")
    UserDO findUserDoByNativeQuery(Long id);

}

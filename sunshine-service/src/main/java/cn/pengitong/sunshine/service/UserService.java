package cn.pengitong.sunshine.service;

import cn.pengitong.sunshine.persist.dao.bean.UserDO;
import cn.pengitong.sunshine.persist.repository.CrudUserRepository;
import cn.pengitong.sunshine.persist.repository.UserRepository;
import cn.pengitong.sunshine.service.model.UserModel;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 **/
@Service
public class UserService {

    @Resource
    private CrudUserRepository crudArticleContentRepository;
    @Resource
    private UserRepository userRepository;

    public UserModel queryUserById(Long userId) {
        UserDO userDO = crudArticleContentRepository.findById(userId).get();
        UserModel userModel = assembleUserModel(userDO);
        return userModel;
    }

    public List<UserModel> queryAll() {
        Iterable<UserDO> userDOS = crudArticleContentRepository.findAll();
        return Lists.newArrayList(userDOS).stream()
                .map(this::assembleUserModel).collect(Collectors.toList());
    }

    public void insertUser() {
        UserDO userDO = new UserDO(1L, "123123", "name1", "psw1");
        UserDO save = crudArticleContentRepository.save(userDO);
        System.out.println(save);
    }

    private UserModel assembleUserModel(UserDO userDO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDO.getId());
        userModel.setAccount(userDO.getAccount());
        userModel.setName(userDO.getName());
        userModel.setPwd(userDO.getPwd());
        return userModel;
    }

    public UserModel findUserById(Long userId) {
        UserDO userDO = userRepository.findUserDOById(userId);
        return assembleUserModel(userDO);
    }

    public UserModel findUserByQuery(Long userId) {
        UserDO userDOByQuery = userRepository.findUserDOByQuery(userId);
        return assembleUserModel(userDOByQuery);
    }

    public UserModel findUserDoByNativeQuery(Long userId) {
        UserDO userDOByQuery = userRepository.findUserDoByNativeQuery(userId);
        return assembleUserModel(userDOByQuery);
    }
}

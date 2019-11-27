package cn.pengitong.sunshine.client;

import cn.pengitong.sunshine.service.UserService;
import cn.pengitong.sunshine.service.model.UserModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: chen peng
 * @create: 2019-11-11
 * @description:
 *
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/list/{userId}")
    @ResponseBody
    public Object getAll(@PathVariable("userId") Long userId) {
        UserModel userModel = userService.queryUserById(userId);
        return userModel;
    }

    @GetMapping(value = "/list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object addUser() {
        userService.insertUser();
        return userService.queryAll();
    }

    @RequestMapping("/find/{userId}")
    public Object findUser(@PathVariable("userId") Long userId) {
        return "345";
//        return userService.findUserById(userId);
    }

    @RequestMapping("/query/{userId}")
    public Object queryUser(@PathVariable("userId") Long userId) {
        return userService.findUserByQuery(userId);
    }

    @RequestMapping("/queryNative/{userId}")
    @ResponseBody
    public Object queryNativeUser(@PathVariable("userId") Long userId) {
        return userService.findUserDoByNativeQuery(userId);
    }

}

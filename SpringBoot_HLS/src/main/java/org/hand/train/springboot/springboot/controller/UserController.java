package org.hand.train.springboot.springboot.controller;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * UserController
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 17:25 2019/12/3
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 查询所有用户
     *
     * @return List<UserInfo>
     * @author Fcant
     * @date 18:39 2019/12/3
     */
    @GetMapping()
    public List<UserInfo> selectAllUser() {
        return userService.selectAllUser();
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return UserInfo
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    @GetMapping("/{id}")
    UserInfo selectUserById(@PathVariable int id) {
        return userService.selectUserById(id);
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    @PostMapping()
    @Valid
    UserInfo addUser(@RequestBody @Valid UserInfo userInfo) {
        userService.addUser(userInfo);
        return userInfo;
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:41 2019/12/3
     */
    @PutMapping("/update")
    UserInfo updateUser(@RequestBody @Valid UserInfo userInfo) {
        return userService.updateUser(userInfo);
    }

    /**
     * 删除用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:41 2019/12/3
     */
    @DeleteMapping()
    UserInfo delUser(@RequestBody UserInfo userInfo) {
        return userService.delUser(userInfo);
    }
}

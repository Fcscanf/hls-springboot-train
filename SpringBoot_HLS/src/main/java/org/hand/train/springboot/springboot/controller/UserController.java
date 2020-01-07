package org.hand.train.springboot.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.service.impl.UserServiceImpl;
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
@Api
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 查询所有用户
     *
     * @return List<UserInfo>
     * @author Fcant
     * @date 18:39 2019/12/3
     */
    @ApiOperation(value = "查询所有用户")
    @GetMapping()
    public List<UserInfo> selectAllUser(UserInfo userInfo) {
        return userService.selectAllUser(userInfo);
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return UserInfo
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    @ApiOperation(value = "根据ID查询用户信息")
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
    @ApiOperation(value = "添加新用户")
    @PostMapping()
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
    @ApiOperation(value = "更新用户信息")
    @PutMapping()
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
    @ApiOperation(value = "删除用户信息")
    @DeleteMapping()
    UserInfo delUser(@RequestBody UserInfo userInfo) {
        return userService.delUser(userInfo);
    }
}

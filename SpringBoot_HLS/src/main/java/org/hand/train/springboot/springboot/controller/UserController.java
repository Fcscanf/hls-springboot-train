package org.hand.train.springboot.springboot.controller;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.exception.GlobalException;
import org.hand.train.springboot.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    @GetMapping("/getall")
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
    @GetMapping("/get/{id}")
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
    @PostMapping("/add")
    @Valid
    UserInfo addUser(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) throws GlobalException {
        if (bindingResult.hasErrors()) {
            String error_message = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                error_message += error.getDefaultMessage() + ",";
            }
            throw new GlobalException(error_message.substring(0, error_message.length() -1));
        }
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
    UserInfo updateUser(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) throws GlobalException {
        if (bindingResult.hasErrors()) {
            String error_message = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                error_message += error.getDefaultMessage() + ",";
            }
            throw new GlobalException(error_message.substring(0, error_message.length() -1));
        }
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
    @DeleteMapping("/del")
    UserInfo delUser(@RequestBody UserInfo userInfo) {
        return userService.delUser(userInfo);
    }
}

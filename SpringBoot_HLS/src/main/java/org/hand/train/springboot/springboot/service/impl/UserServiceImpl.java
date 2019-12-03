package org.hand.train.springboot.springboot.service.impl;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.mapper.UserMapper;
import org.hand.train.springboot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 17:27 2019/12/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserInfo selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userMapper.addUser(userInfo);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return userMapper.updateUser(userInfo);
    }

    @Override
    public int delUser(UserInfo userInfo) {
        return userMapper.delUser(userInfo);
    }
}

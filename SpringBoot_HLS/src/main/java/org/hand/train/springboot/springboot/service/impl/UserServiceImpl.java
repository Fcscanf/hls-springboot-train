package org.hand.train.springboot.springboot.service.impl;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.mapper.IUserMapper;
import org.hand.train.springboot.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl implements IUserService {

    /**
     * 数据库操作失败的数字返回值
     */
    private final int FAILURE_CODE = 0;

    @Autowired
    IUserMapper userMapper;

    @Override
    public List<UserInfo> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserInfo selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        int i = userMapper.addUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        return userInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        return userInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInfo delUser(UserInfo userInfo) {
        int i = userMapper.delUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        userInfo = userMapper.selectUserById(userInfo.getUserId());
        return userInfo;
    }
}

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

    /**
     * 数据库操作失败的数字返回值
     */
    private final int FAILURE_CODE = 0;

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return List<UserInfo>
     * @author Fcant
     * @date 18:39 2019/12/3
     */
    @Override
    public List<UserInfo> selectAllUser() {
        return userMapper.selectAllUser();
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return UserInfo
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    @Override
    public UserInfo selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        int i = userMapper.addUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
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
    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        return userInfo;
    }

    /**
     * 删除用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:41 2019/12/3
     */
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

package org.hand.train.springboot.springboot.service.impl;

import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.cache.IUserCache;
import org.hand.train.springboot.springboot.mapper.IUserMapper;
import org.hand.train.springboot.springboot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "user", cacheManager = "userCacheManager")
public class UserServiceImpl implements IUserService {

    /**
     * 数据库操作失败的数字返回值
     */
    private final int FAILURE_CODE = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserCache userCache;

    @Autowired
    IUserMapper userMapper;

    @Override
    public List<UserInfo> selectAllUser() {
        List<UserInfo> usersList;
        usersList = userCache.getUsersList("userList");
        if (usersList.isEmpty()) {
            LOGGER.info("从数据库查询所有用户信息");
            usersList = userMapper.selectAllUser();
            userCache.listUsersSave("userList", usersList);
        }
        return usersList;
    }

    @Cacheable(cacheNames = "user", key = "#id")
    @Override
    public UserInfo selectUserById(int id) {
        LOGGER.info("从数据库查询ID为 {} 的用户" , id);
        return userMapper.selectUserById(id);
    }

    /**
     * 添加用户
     * 此处缓存主键使用Mybatis回填的自增主键
     *
     * @param userInfo
     * @return UserInfo
     * @author Fcant 9:22 2019/12/6
     */
    @CachePut(cacheNames = "user", key = "#result.userId")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        int i = userMapper.addUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        return userInfo;
    }

    @CachePut(cacheNames = "user", key = "#userInfo.userId")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        if (i == FAILURE_CODE) {
            return null;
        }
        return userInfo;
    }

    @CacheEvict(beforeInvocation = true, cacheNames = "user", key = "#userInfo.userId")
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

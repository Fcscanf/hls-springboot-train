package org.hand.train.springboot.springboot.cache.impl;

import com.google.gson.Gson;
import org.hand.train.springboot.springboot.bean.UserInfo;
import org.hand.train.springboot.springboot.cache.IUserCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * IUserCacheImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant 10:26 2019/12/6
 */
@Service
public class UserCacheImpl implements IUserCache {

    private final StringRedisTemplate redisTemplate;

    public UserCacheImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 将查询到的Users的List集合缓存到Redis
     *
     * @param key 缓存的Key
     * @param userInfoList 缓存的集合
     * @author Fcant 10:21 2019/12/6
     */
    @Override
    public void listUsersSave(String key, List<UserInfo> userInfoList) {
        Gson gson = new Gson();
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(key, gson.toJson(userInfoList));
    }

    /**
     * 从缓存中获取用户集合
     *
     * @param key 获取缓存的key
     * @return List<UserInfo>
     * @author Fcant 10:25 2019/12/6
     */
    @Override
    public List<UserInfo> getUsersList(String key) {
        ValueOperations<String,String> vo = redisTemplate.opsForValue();
        String userList = vo.get(key);
        Gson gson = new Gson();
        List<UserInfo> userInfoList = gson.fromJson(userList, List.class);
        return userInfoList == null ? new ArrayList<>() : userInfoList;
    }
}

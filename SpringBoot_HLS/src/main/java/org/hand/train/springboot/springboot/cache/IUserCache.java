package org.hand.train.springboot.springboot.cache;

import org.hand.train.springboot.springboot.bean.UserInfo;

import java.util.List;

/**
 * UserCache
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant 10:18 2019/12/6
 */
public interface IUserCache {

    /**
     * 将查询到的Users的List集合缓存到Redis
     *
     * @param key
     * @param userInfoList
     * @author Fcant 10:21 2019/12/6
     */
    void listUsersSave(String key, List<UserInfo> userInfoList);

    /**
     * 从缓存中获取用户集合
     *
     * @param key
     * @return List<UserInfo>
     * @author Fcant 10:25 2019/12/6
     */
    List<UserInfo> getUsersList(String key);
}

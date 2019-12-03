package org.hand.train.springboot.springboot.mapper;

import org.hand.train.springboot.springboot.bean.UserInfo;

import java.util.List;

/**
 * UserMapper
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 17:20 2019/12/3
 */
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return List<UserInfo>
     * @author Fcant
     * @date 18:39 2019/12/3
     */
    List<UserInfo> selectAllUser();

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return UserInfo
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    UserInfo selectUserById(int id);

    /**
     * 添加用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:40 2019/12/3
     */
    int addUser(UserInfo userInfo);

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:41 2019/12/3
     */
    int updateUser(UserInfo userInfo);

    /**
     * 删除用户
     *
     * @param userInfo
     * @return int
     * @author Fcant
     * @date 18:41 2019/12/3
     */
    int delUser(UserInfo userInfo);
}

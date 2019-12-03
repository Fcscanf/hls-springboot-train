package org.hand.train.springboot.springboot.bean;

import lombok.Data;

import java.sql.Date;

/**
 * UserInfo
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 17:16 2019/12/3
 */
@Data
public class UserInfo {
    private int userId;
    private String userName;
    private int age;
    private Date createTime;
}

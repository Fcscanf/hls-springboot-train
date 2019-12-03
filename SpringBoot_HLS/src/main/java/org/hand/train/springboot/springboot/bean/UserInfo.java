package org.hand.train.springboot.springboot.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @Max(value = 120, message = "年龄不能超过120岁，否则不合法")
    private int age;
    private Date createTime;
}

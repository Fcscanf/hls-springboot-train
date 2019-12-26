package org.hand.train.springboot.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "UserInfo", description = "用户信息实体类")
@Data
public class UserInfo {
    @ApiModelProperty(name = "用户ID")
    private int userId;

    @ApiModelProperty(name = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(name = "年龄")
    @Max(value = 120, message = "年龄不能超过120岁，否则不合法")
    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "用户创建时间", hidden = true)
    private Date createTime;
}

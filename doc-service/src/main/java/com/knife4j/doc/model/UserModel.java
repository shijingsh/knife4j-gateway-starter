package com.knife4j.doc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserModel
 * @author jmac
 * @since 2022-08-28
 */
@ApiModel("用户")
public class UserModel {

    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    @ApiModelProperty(value = "是否可用", required = true, example = "true")
    private Boolean enable;

    @ApiModelProperty(value = "年龄", required = true, example = "18")
    private Integer age;

    public UserModel() {
    }

    public UserModel(Long id, String username, Boolean enable, Integer age) {
        this.id = id;
        this.username = username;
        this.enable = enable;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

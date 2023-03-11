package com.knife4j.doc.controller;

import com.knife4j.doc.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * UserController
 * <p>只写了一个例子，使用方法和springboot一样</p>
 * @author jmac
 * @since 2022-08-28
 */
@RestController
@Api(tags = "用户接口2", produces = "application/json")
@RequestMapping("/user2")
public class UserController {


    @ApiOperation(value = "用户列表2", httpMethod = "GET")
    @GetMapping("/list")
    public List<UserModel> list(){
        return Arrays.asList(new UserModel(1L, "admin", true, 18),
                new UserModel(2L, "app", true, 19));
    }

}

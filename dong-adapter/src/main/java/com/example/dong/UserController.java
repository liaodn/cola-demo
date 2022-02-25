package com.example.dong;

import com.alibaba.cola.dto.Response;
import com.example.dong.api.UserServiceI;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:13 PM
 *
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/test")
    public Response getUserInfo(@RequestBody UserQry userQry) {
        return userServiceI.findByUsernameLike(userQry);
    }

    @PostMapping("/test1")
    public Response getUserInfo(@RequestBody SexQry sexQry) {
        return userServiceI.findBySex(sexQry);
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody UserCO userCO) {
        return userServiceI.insert(userCO);
    }
}

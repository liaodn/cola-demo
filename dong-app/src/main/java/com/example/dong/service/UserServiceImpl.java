package com.example.dong.service;

import com.alibaba.cola.dto.Response;
import com.example.dong.api.UserServiceI;
import com.example.dong.command.query.UserQryExe;
import com.example.dong.dto.UserQry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:04 PM
 *
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UserQryExe userQryExe;

    @Override
    public Response findByUsernameLike(UserQry userQry) {
        return userQryExe.execute(userQry);
    }
}

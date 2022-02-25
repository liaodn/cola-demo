package com.example.dong.service;

import com.alibaba.cola.dto.Response;
import com.example.dong.api.UserServiceI;
import com.example.dong.command.UserCOAddCmd;
import com.example.dong.command.query.SexQryExe;
import com.example.dong.command.query.UsernameQryExe;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;
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
    private UsernameQryExe usernameQryExe;

    @Resource
    private SexQryExe sexQryExe;

    @Resource
    private UserCOAddCmd userCOAddCmd;

    @Override
    public Response findByUsernameLike(UserQry userQry) {
        return usernameQryExe.execute(userQry);
    }

    @Override
    public Response findBySex(SexQry qry) {
        return sexQryExe.execute(qry);
    }

    @Override
    public Response insert(UserCO userCO) {

        return userCOAddCmd.execute(userCO);
    }
}

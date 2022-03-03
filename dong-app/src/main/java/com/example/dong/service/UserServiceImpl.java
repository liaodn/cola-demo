package com.example.dong.service;

import com.alibaba.cola.dto.Response;
import com.example.dong.api.UserServiceI;
import com.example.dong.command.UserCOAddCmd;
import com.example.dong.command.query.PageQryExe;
import com.example.dong.command.query.SexQryExe;
import com.example.dong.command.query.UsernameQryExe;
import com.example.dong.common.page.PaginationDTO;
import com.example.dong.dto.PageQry;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:04 PM
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UsernameQryExe usernameQryExe;

    @Resource
    private SexQryExe sexQryExe;

    @Resource
    private PageQryExe pageQryExe;

    @Resource
    private UserCOAddCmd userCOAddCmd;

    @Autowired
    private UserServiceImpl userServiceI;

    @Override
    public Response findByUsernameLike(UserQry userQry) {
        return usernameQryExe.execute(userQry);
    }


    @Override
    public Response findBySex(SexQry qry) {
        test();
        return sexQryExe.execute(qry);
    }

    public void test() {
        log.info("测试类");
    }

    @Override
    public Response findPage(PaginationDTO<PageQry> pageQry) {
        userServiceI.test();
        ((UserServiceImpl) AopContext.currentProxy()).test();
        return pageQryExe.execute(pageQry);
    }

    @Override
    public Response insert(UserCO userCO) {

        return userCOAddCmd.execute(userCO);
    }
}

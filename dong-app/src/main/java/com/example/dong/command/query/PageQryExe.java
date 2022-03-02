package com.example.dong.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.dto.PageQry;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.clientobject.UserCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 4:49 PM
 *
 */
@Component
public class PageQryExe {

    @Autowired
    private UserGateway userGateway;

    public SingleResponse<Page<UserCO>> execute(PageQry pageQry) {
        Page<User> page = userGateway.findPage(pageQry.getPageIndex());
        Page<UserCO> users = page.map(user -> {
            UserCO userProfileCO = new UserCO();
            BeanUtils.copyProperties(user, userProfileCO);
            return userProfileCO;
        });
        return SingleResponse.of(users);
    }
}

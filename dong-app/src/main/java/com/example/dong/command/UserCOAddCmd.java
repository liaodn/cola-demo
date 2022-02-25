package com.example.dong.command;

import com.alibaba.cola.dto.SingleResponse;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/2/25 4:33 PM
 *
 */
@Component
public class UserCOAddCmd {

    @Autowired
    private UserGateway userGateway;


    public SingleResponse<User> execute(UserCO userCO) {
        User user = new User();
        BeanUtils.copyProperties(userCO, user);
        User result = userGateway.insert(user);
        return SingleResponse.of(result);
    }
}

package com.example.dong.command.query;

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
 * @Date: 2022/1/25 5:04 PM
 *
 */
@Component
public class UserQryExe {

    @Autowired
    private UserGateway userGateway;

    public SingleResponse<UserCO> execute(UserQry qry) {
        User user = userGateway.findByUsernameLike(qry.getUsername());
        UserCO userProfileCO = new UserCO();
        BeanUtils.copyProperties(user, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }
}

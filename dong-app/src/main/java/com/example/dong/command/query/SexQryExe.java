package com.example.dong.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:04 PM
 *
 */
@Component
public class SexQryExe {

    @Autowired
    private UserGateway userGateway;

    public MultiResponse<UserCO> execute(SexQry qry) {
        List<User> users = userGateway.findBySex(qry.getSex());
        List<UserCO> userCOS = new ArrayList<>();
        users.forEach(u -> {
            UserCO userProfileCO = new UserCO();
            BeanUtils.copyProperties(u, userProfileCO);
            userCOS.add(userProfileCO);
        });
        return MultiResponse.of(userCOS);
    }
}

package com.example.dong.gatewayimpl;

import com.example.dong.convertor.UserConvertor;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.repository.UserRepository;
import com.example.dong.repository.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/26 1:27 PM
 *
 */

@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsernameLike(String userName) {
        UserDO userDO = userRepository.findByUsernameLike(userName).orElse(new UserDO());
        return UserConvertor.to(userDO);
    }
}

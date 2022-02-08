package com.example.dong.gatewayimpl;

import com.example.dong.convertor.UserConvertor;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.repository.UserRepository;
import com.example.dong.repository.dataobject.QUserDO;
import com.example.dong.repository.dataobject.UserDO;
import com.google.common.collect.Lists;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 3:30 PM
 *
 */
@Component
public class UserGatewayImpl implements UserGateway {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByUsernameLike(String userName) {
        UserDO userDO = userRepository.findByUsernameLike("%" + userName + "%").orElse(new UserDO());
        return UserConvertor.to(userDO);
    }

    @Override
    public List<User> findBySex(String sex) {
        QUserDO q = QUserDO.userDO;
        BooleanExpression p = q.sex.equalsIgnoreCase(sex);
        Iterable<UserDO> users = userRepository.findAll(p);
        List<User> userList = new ArrayList<>();
        users.forEach(u -> userList.add(UserConvertor.to(u)));
        return userList;
    }
}

package com.example.dong.gatewayimpl;

import com.example.dong.convertor.UserConvertor;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.repository.UserRepository;
import com.example.dong.repository.dataobject.QUserDO;
import com.example.dong.repository.dataobject.UserDO;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> findBySex(String sex) {
        QUserDO q = QUserDO.userDO;
        BooleanExpression p = q.sex.equalsIgnoreCase(sex);
        Iterable<UserDO> users = userRepository.findAll(p);
        List<User> userList = new ArrayList<>();
        users.forEach(u -> userList.add(UserConvertor.to(u)));
        return userList;
    }

    @Override
    public User insert(User user) {
        UserDO userDO = new UserDO();
        userDO.setUsername(user.getUsername());
        userDO.setSex(user.getSex());
        userDO.setPassword(user.getPassword());
        userDO.setEmail(user.getEmail());
        userDO.setUid(user.getUid());
        UserDO dbUserDO = userRepository.save(userDO);
        User userResult = new User();
        BeanUtils.copyProperties(dbUserDO, userResult);
        return userResult;
    }


}

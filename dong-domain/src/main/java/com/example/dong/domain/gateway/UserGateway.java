package com.example.dong.domain.gateway;

import com.example.dong.domain.user.User;

import java.util.List;
import java.util.Optional;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 3:25 PM
 *
 */
public interface UserGateway {
    User findByUsernameLike(String userName);

    List<User> findBySex(String sex);

    User insert(User user);

}

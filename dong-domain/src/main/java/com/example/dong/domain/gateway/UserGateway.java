package com.example.dong.domain.gateway;

import com.example.dong.domain.user.User;
import org.springframework.data.domain.Page;

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

    Page<User> findPage(int pageIndex);

    User insert(User user);

}

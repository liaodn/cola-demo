package com.example.dong.convertor;

import com.example.dong.domain.user.User;
import com.example.dong.repository.dataobject.UserDO;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:36 PM
 *
 */
public class UserConvertor {

    public static User to(UserDO userDO) {
        User user = new User();
        user.setId(userDO.getId());
        user.setEmail(userDO.getEmail());
        user.setPassword(userDO.getPassword());
        user.setSex(userDO.getSex());
        user.setUsername(userDO.getUsername());
        return user;
    }

}

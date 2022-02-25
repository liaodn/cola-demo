package com.example.dong.api;

import com.alibaba.cola.dto.Response;
import com.example.dong.dto.SexQry;
import com.example.dong.dto.UserQry;
import com.example.dong.dto.clientobject.UserCO;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:58 PM
 *
 */
public interface UserServiceI {
    Response findByUsernameLike(UserQry qry);
    Response findBySex(SexQry qry);
    Response insert(UserCO userCO);
}

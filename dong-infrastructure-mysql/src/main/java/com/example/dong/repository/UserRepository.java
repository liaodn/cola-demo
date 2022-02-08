package com.example.dong.repository;

import com.example.dong.repository.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/24 2:41 PM
 *
 */
public interface UserRepository extends JpaRepository<UserDO, String>, QuerydslPredicateExecutor<UserDO> {
    Optional<UserDO> findByUsernameLike(String userName);
}

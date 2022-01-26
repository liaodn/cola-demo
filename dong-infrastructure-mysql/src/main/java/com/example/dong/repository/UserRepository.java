package com.example.dong.repository;

import com.example.dong.repository.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/24 2:41 PM
 *
 */
public interface UserRepository extends JpaRepository<UserDO, String> {
    Optional<UserDO> findByUsernameLike(String userName);
}

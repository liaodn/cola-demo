package com.example.dong.repository;

import com.example.dong.repository.dataobject.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/26 1:24 PM
 *
 */
public interface UserRepository extends MongoRepository<UserDO, Long> {
    Optional<UserDO> findByUsernameLike(String userName);
}

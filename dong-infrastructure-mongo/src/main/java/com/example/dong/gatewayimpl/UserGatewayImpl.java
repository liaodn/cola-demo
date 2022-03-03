package com.example.dong.gatewayimpl;

import com.example.dong.common.page.PaginationDTO;
import com.example.dong.convertor.UserConvertor;
import com.example.dong.domain.gateway.UserGateway;
import com.example.dong.domain.user.User;
import com.example.dong.dto.PageQry;
import com.example.dong.repository.UserRepository;
import com.example.dong.repository.dataobject.QUserDO;
import com.example.dong.repository.dataobject.UserDO;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.PredicateOperation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
        userDO.setAge(user.getAge());
        UserDO dbUserDO = userRepository.save(userDO);
        User userResult = new User();
        BeanUtils.copyProperties(dbUserDO, userResult);
        return userResult;
    }

    @Override
    public Page<User> findPage(PaginationDTO<PageQry> pageQry) {
        UserDO user = new UserDO();
        user.setUsername(pageQry.getCondition().getUsername());

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains());
        PageRequest pageRequest = PageRequest.of(pageQry.getPageNum(), pageQry.getPageSize(), pageQry.getSort());

        Page<UserDO> page = userRepository.findAll(Example.of(user, matcher), pageRequest);

        return page.map(UserConvertor::to);
    }

    /**
     * Mongo 不支持
     * @param pageQry
     * @return
     */
    @Override
    public Page<User> findPageSpec(PaginationDTO<PageQry> pageQry) {

        return null;
    }

    @Override
    public Page<User> findPageDSL(PaginationDTO<PageQry> pageQry) {

        PageQry qry = pageQry.getCondition();

        PageRequest pageRequest = PageRequest.of(pageQry.getPageNum(), pageQry.getPageSize(), pageQry.getSort());

        QUserDO userDO = QUserDO.userDO;
        Predicate predicate = userDO.username.contains(qry.getUsername())
                .and(userDO.age.eq(qry.getAge()));

        userRepository.findAll(predicate, pageRequest);
        Page<UserDO> page = userRepository.findAll(predicate, pageRequest);

        return page.map(UserConvertor::to);
    }

}

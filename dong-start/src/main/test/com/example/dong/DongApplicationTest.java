package com.example.dong;

import com.alibaba.cola.dto.Response;
import com.example.dong.api.UserServiceI;
import com.example.dong.command.query.UsernameQryExe;
import com.example.dong.domain.Person;
import com.example.dong.dto.UserQry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@SpringBootTest(classes = DongApplication.class)
@RunWith(SpringRunner.class)
public class DongApplicationTest {


    @Autowired
    private UserServiceI userServiceI;

    @Test
    public void testUserServiceI(){
        UserQry qry = new UserQry();
        qry.setUsername("冬");
        Response response = userServiceI.findByUsernameLike(qry);
        System.out.println(response);

    }

}

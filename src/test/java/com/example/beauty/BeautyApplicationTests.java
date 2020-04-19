package com.example.beauty;

import com.example.beauty.dao.UserDao;
import com.example.beauty.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class BeautyApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        List<User> list = new ArrayList<>();
        for (int i=0;i<3;i++){
            User user = new User();
            user.setPhoneNumber("748395234");
            user.setPassword("fadsfa");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            list.add(user);
        }
        Integer integer = userDao.addUsers(list);
        log.info("integer-{}",integer);
    }

}

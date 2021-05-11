package com.example.shop.test;

import com.example.shop.pojo.User;
import com.example.shop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private final UserServiceImpl service = new UserServiceImpl();
    @Test
    void registerUser() {
        Date date = new Date(2021, 12, 12);
        User user = new User(1, "wqs2", "1212", date, date, "女");
        System.out.println(service.registerUser(user));
    }

    @Test
    void loginUser() {
        Date date = new Date(2021, 12, 12);
        User user = new User(1, "wqs2", "1212", date, date, "女");
        System.out.println(service.loginUser(user));
    }

    @Test
    void exitsUserName() {
    }
}
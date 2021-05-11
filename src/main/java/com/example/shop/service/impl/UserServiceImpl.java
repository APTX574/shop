package com.example.shop.service.impl;

import com.example.shop.dao.UserDao;
import com.example.shop.dao.impl.UserDaoImpl;
import com.example.shop.pojo.User;
import com.example.shop.service.UserServie;

public class UserServiceImpl implements UserServie {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 用于处理用户注册的业务逻辑
     * @param user 注册的用户封装对象
     * @return 如果注册成功返回用户对象，失败则返回null
     */
    @Override
    public User registerUser(User user) {
        if (exitsUserName(user.getName())) {
            return null;
        }
        userDao.saveUser(user);
        return user;
    }

    /**
     * 用于处理用户登录的业务逻辑
     * @param user 进行登录验证的用户封装对象
     * @return  如果登录成功则返回用户对象，失败则返回null
     */
    @Override
    public User loginUser(User user) {
        if (userDao.queryUserRight(user.getName(), user.getPassword())) {
            return user;
        }
        return null;
    }

    /**
     * 验证用户名是否存在
     * @param userName 待测验用户名
     * @return 如果用户名在数据库中不存在则返回true，反之返回false
     */
    @Override
    public boolean exitsUserName(String userName) {
        return userDao.queryUserName(userName);
    }

}

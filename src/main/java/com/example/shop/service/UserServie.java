package com.example.shop.service;

import com.example.shop.pojo.User;

public interface UserServie {
    /**
     * 处理用户注册的业务逻辑
     * @param user 注册的用户封装对象
     * @return
     */
    public User registerUser(User user);

    /**
     * 处理用户登录的业务逻辑
     * @param user 进行登录验证的用户封装对象
     */
    public User loginUser(User user);

    /**
     * 测试用户的注册用户名是否可用
     * @param userName 待测验用户名
     */
    public boolean exitsUserName(String userName);

}

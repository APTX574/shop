package com.example.shop.dao;

import com.example.shop.pojo.User;


/**
 *
 * @author aptx
 */
public interface UserDao  {

    /**
     * 通过用户名去查询用户信息
     * @param name 查询的用户名
     * @return 返回查询到的用户对象，若没查到则返回null
     */
    User queryUser(String name);

    boolean queryUserRight(String name, String pasword);

    boolean saveUser(User user);

    boolean queryUserName(String name);


}

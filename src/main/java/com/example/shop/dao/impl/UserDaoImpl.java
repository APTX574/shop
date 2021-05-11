package com.example.shop.dao.impl;

import com.example.shop.dao.BaseDao;
import com.example.shop.dao.UserDao;
import com.example.shop.pojo.User;

/**
 * @author aptx
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    /**
     * 查询数据库中的user信息，根据用户名
     * @param name 查询的用户名
     * @return 返回查询到的封装对象，若没有查到则返回null
     */
    @Override
    public User queryUser(String name) {

        String sql = "select `id`,`name`,`password`,`sex`,`birthday`,`create` from user where name=?";
        return queryForOne(sql, User.class, name);
    }

    /**
     * 讲新的用户信息添加到数据库中
     * @param user 需要添加的用户对象
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        String sql = "insert into user(`name`,`password`,`sex`,`birthday`,`create_time`) value(?,?,?,?,?)";
        return update(sql, user.getName(), user.getPassword(), user.getSex(), user.getBirthday(), user.getCreateTime()) == 1;
    }

    /**
     * 查询用户名和密码是否存在
     * @param name 需要查询的用户名
     * @param password 需要查询用户名的对象密码
     * @return
     */
    @Override
    public boolean queryUserRight(String name, String password) {
        String sql = "select count(*)  from user where name=? and password=?";
        long f = queryForSingleValue(sql, name, password);
        return f == 1;
    }

    @Override
    public boolean queryUserName(String name) {
        String sql = "select count(*)  from user where name=? ";
        long f = queryForSingleValue(sql, name);
        return f == 1;
    }
}

package com.example.shop.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.ResultSetHandler;

import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 利用获得德鲁伊数据库连接，利用JbUtils实现增删改查工作
 *
 * @author aptx
 */
public abstract class BaseDao<T> {
    private final QueryRunner runner = new QueryRunner();
    private Connection conn;
    public int update(String sql, Object... args) {
        try {
            conn = JdbcUtil.getConnection();
            return runner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return -1;
    }

    public T queryForOne(String sql, Class<T> type, Object... args) {

        try {
            conn = JdbcUtil.getConnection();
            return runner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return null;
    }

    public List<T> queryForList(String sql, Class<T> type, Object... args) {
        try {
            conn = JdbcUtil.getConnection();
            return runner.query(conn, sql, new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return null;
    }

    public Long queryForSingleValue(String sql, Object... args) {
        try {
            conn = JdbcUtil.getConnection();
            return  runner.query(conn, sql, new ScalarHandler<Long>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return -1L;
    }
    public int update(Connection conn, String sql, Object... args) {
        try {
            conn = JdbcUtil.getConnection();
            return runner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public T queryForOne(Connection conn,String sql,Class<T> type, Object... args)  {
        try {
            conn = JdbcUtil.getConnection();
            return runner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<T> queryForList(Connection conn,String sql, Class<T> type, Object... args) {
        try {
            conn = JdbcUtil.getConnection();
            return runner.query(conn, sql, new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int queryForSingleValue(Connection conn, String sql, Object... args) {

        try {
            conn = JdbcUtil.getConnection();
            return runner.query(conn, sql, new ScalarHandler<Integer>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }


}

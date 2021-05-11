package utils;

import com.alibaba.druid.pool.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    /*定义数据库连接池常量并且通过静态代码块初始化,类似单列*/
    private static DruidDataSource dataSource;
    static {
        try {
            //定义资源变量
            Properties prop = new Properties();
            //通过类的加载器获取资源输入流
            InputStream res = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(res);     //载入资源
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);   //通过数据库连接池工厂获得数据库连接池
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();      //通过数据库连接池获得连接
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();               //关闭数据库连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

}

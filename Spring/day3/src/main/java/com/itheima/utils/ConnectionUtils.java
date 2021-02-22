package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 链接的工具类
 * 用于从数据源中获取一个链接并且实现和线程绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl =new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的链接
     * @return
     */
    public Connection getThreadConnection() {
        //1.先从ThreadLoacl上获取链接
        Connection conn = tl.get();
        //2判断线程上是否有链接
        try {
            if (conn == null) {
                //3.从数据源中获取一个链接并且和线程绑定，并且存入ThreadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //返回当前线程上的链接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void removeTransaction(){
        /**
         * 把线程和事务解绑
         */
        tl.remove();
    }
}

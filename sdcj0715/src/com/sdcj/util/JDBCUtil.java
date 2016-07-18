package com.sdcj.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 封装数据库连接的工具类
 * 
 * @author peter.Sun
 *
 */
public class JDBCUtil {
	private static DataSource ds;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	// static{}静态代码块。只在类加载时执行一次。类加载是在实例化这个类的实例之前执行。
	static {
		Properties properties = new Properties();
		InputStream is = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
		try {
			properties.load(is);
			ds = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			System.out.println("加载资源文件错误！");
			e.printStackTrace();
		}
	}

	/**
	 * 获得数据库连接的方法
	 * 
	 * @return 数据库的连接对象
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 先从本地线程类中取连接对象
		Connection conn = threadLocal.get();
		// 判断 连接是否为空，或连接是否关闭。
		if (conn == null || conn.isClosed()) {
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}

	/**
	 * 释放连接对象的方法
	 */
	public static void closeConnection() {
		try {
			Connection conn = threadLocal.get();
			if (conn != null && !conn.isClosed()) {
				conn.close();// 释放连接
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			threadLocal.set(null);// 清空
		}
	}
}

package com.neu.jianfu.util;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil_dhcp {
	private static String driverName;
	private static String url;
	private static String userName;
	private static String password;
	private static BasicDataSource ds;
/*
 * jdbc工具类
 * 
 */
	static{
		try {
		//加载驱动
		//加载连接参数
		loadParam();
		//初始化连接池对象
		ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setInitialSize(10);//设置初始化连接数
		ds.setMaxActive(100);//设置最大连接数
		ds.setMaxWait(5000);
		ds.setMinIdle(5);//最小空闲连接数
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//设置超时时间，毫秒位单位
		
	}
	public static void loadParam(){
		Properties prop = new Properties();
		try {
			prop.load(DBUtil_dhcp.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			driverName = prop.getProperty("classDriver");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		Connection conn = null;
		conn = ds.getConnection();
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(getConn());
	}

}

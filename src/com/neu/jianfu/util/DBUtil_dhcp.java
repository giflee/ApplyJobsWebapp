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
 * jdbc������
 * 
 */
	static{
		try {
		//��������
		//�������Ӳ���
		loadParam();
		//��ʼ�����ӳض���
		ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setInitialSize(10);//���ó�ʼ��������
		ds.setMaxActive(100);//�������������
		ds.setMaxWait(5000);
		ds.setMinIdle(5);//��С����������
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���ó�ʱʱ�䣬����λ��λ
		
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

package com.neu.jianfu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neu.jianfu.entity.Admin;
import com.neu.jianfu.util.DBUtil_dhcp;



public class AdminDao {
		
	public Admin findByUserName(String adminName){
		String sql = "select * from admin where adminName =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPassword(rs.getString("adminPassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(rs, pstmt, conn);
		}
		return admin;
	}
}

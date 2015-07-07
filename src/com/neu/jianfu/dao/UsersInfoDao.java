package com.neu.jianfu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neu.jianfu.entity.UsersInfo;
import com.neu.jianfu.util.DBUtil_dhcp;
import com.neu.jianfu.util.ShowUsersByJobId;

public class UsersInfoDao {
	public void addUsersInfo(UsersInfo usersinfo){
		String sql = "insert into usersinfo(userId,userName,userSex,userEdu,userMaster,userSkill,jobId) values(userseq0.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usersinfo.getUserName());
			pstmt.setString(2, usersinfo.getUserSex());
			pstmt.setString(3, usersinfo.getUserEdu());
			pstmt.setString(4, usersinfo.getUserMaster());
			pstmt.setString(5, usersinfo.getUserSkill());
			pstmt.setInt(6, usersinfo.getJobId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<ShowUsersByJobId> findByJobId(Integer jobId){
		String sql = "select username,usersex,useredu,userMaster,userskill,jobname from jobs,usersinfo where jobs.jobid = ? and jobs.jobid = usersinfo.jobid";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShowUsersByJobId> lists = new ArrayList<ShowUsersByJobId>();
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jobId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShowUsersByJobId sbj = new ShowUsersByJobId();
				sbj.setJobName(rs.getString("jobName"));
				sbj.setUserEdu(rs.getString("userEdu"));
				sbj.setUserMaster(rs.getString("userMaster"));
				sbj.setUserName(rs.getString("userName"));
				sbj.setUserSex(rs.getString("userSex"));
				sbj.setUserSkill(rs.getString("userSkill"));
				lists.add(sbj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(rs, pstmt, conn);
		}
		return lists;
	}
}

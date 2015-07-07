package com.neu.jianfu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.DbcpException;

import com.neu.jianfu.entity.Jobs;
import com.neu.jianfu.util.DBUtil_dhcp;



public class JobsDao {
	public List<Jobs> findAll(){
		String sql = "select * from jobs";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Jobs> jobslist = new ArrayList<Jobs>();
		try {
			conn = DBUtil_dhcp.getConn();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				Jobs job = new Jobs();
				job.setJobId(rs.getInt("jobId"));
				job.setJobName(rs.getString("jobName"));
				job.setJobDuty(rs.getString("jobDuty"));
				job.setJobReq(rs.getString("jobReq"));
				job.setJobRes(rs.getString("jobRes"));
				jobslist.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(rs, stmt, conn);
		}
		return jobslist;
	}
	
	public void insertJobs(Jobs job){
		String sql = "insert into jobs(jobId,jobName,jobDuty,jobReq) values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, job.getJobId());
			pstmt.setString(2, job.getJobName());
			pstmt.setString(3, job.getJobDuty());
			pstmt.setString(4, job.getJobReq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(null, pstmt, conn);
		}
	}
	
	public void deleteById(Integer jobId){
		String sql = "delete from jobs where jobId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jobId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(null, pstmt, conn);
		}
	}
	
	public Jobs findByJobId(Integer jobId){
		String sql = "select * from jobs where jobId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Jobs job = new Jobs();
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jobId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				job.setJobId(rs.getInt("jobId"));
				job.setJobName(rs.getString("jobName"));
				job.setJobDuty(rs.getString("jobDuty"));
				job.setJobReq(rs.getString("jobReq"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return job;
	}
	
	public void updateJob(Jobs job){
		String sql ="update jobs set jobname = ?,jobduty = ?,jobReq = ? where jobid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job.getJobName());
			pstmt.setString(2, job.getJobDuty());
			pstmt.setString(3, job.getJobReq());
			pstmt.setInt(4, job.getJobId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(null, pstmt, conn);
		}
		
	}
	
	public List<Jobs> findByPage(int page,int pageSize){//分页
		int start = (page-1)*pageSize+1;
		int end = page*pageSize;
		String sql = "select * from(select e.*,rownum r from (select * from Jobs) e where rownum<=?) where r>=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Jobs> jobslist = new ArrayList<Jobs>();
		try {
			conn = DBUtil_dhcp.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Jobs job = new Jobs();
				job.setJobId(rs.getInt("jobId"));
				job.setJobName(rs.getString("jobName"));
				job.setJobDuty(rs.getString("jobDuty"));
				job.setJobReq(rs.getString("jobReq"));
				job.setJobRes(rs.getString("jobRes"));
				jobslist.add(job);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(rs, pstmt, conn);
		}
		return jobslist;
	}
	
	public int maxPage(int pageSize){//返回最大页数
		String sql = "select count(*) from jobs";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		int maxPage = 0;
		try {
			conn = DBUtil_dhcp.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
			maxPage = count/pageSize+1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil_dhcp.close(rs, stmt, conn);
		}
		return maxPage;
	}
}

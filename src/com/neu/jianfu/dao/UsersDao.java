package com.neu.jianfu.dao;

import java.util.List;

import com.neu.jianfu.entity.UsersInfo;

public class UsersDao {
	public List<UsersInfo> findByJobId(Integer jobId){
		String sql = "select userName,userSex,userEdu,userMaster,userSkill from usersinfo,jobs where jobs.jobId =? and jobs.userId = userinfo.userId";
		return null;
	}
}

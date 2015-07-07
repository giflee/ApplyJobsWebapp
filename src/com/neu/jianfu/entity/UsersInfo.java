package com.neu.jianfu.entity;

public class UsersInfo {
	
	private Integer userId;
	private String userName;
	private String userSex;
	private String userEdu;
	private String userMaster;
	private String userSkill;
	private Integer jobId;
	
	public UsersInfo() {
		
	}
	public UsersInfo(Integer userId, String userName, String userSex,
			String userEdu, String userMaster, String userSkill) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userEdu = userEdu;
		this.userMaster = userMaster;
		this.userSkill = userSkill;
	}
	
	public UsersInfo(Integer userId, String userName, String userSex,
			String userEdu, String userMaster, String userSkill, Integer jobId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userEdu = userEdu;
		this.userMaster = userMaster;
		this.userSkill = userSkill;
		this.jobId = jobId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserEdu() {
		return userEdu;
	}
	public void setUserEdu(String userEdu) {
		this.userEdu = userEdu;
	}
	public String getUserMaster() {
		return userMaster;
	}
	public void setUserMaster(String userMaster) {
		this.userMaster = userMaster;
	}
	public String getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	@Override
	public String toString() {
		return "UsersInfo [userId=" + userId + ", userName=" + userName
				+ ", userSex=" + userSex + ", userEdu=" + userEdu
				+ ", userMaster=" + userMaster + ", userSkill=" + userSkill
				+ ", jobId=" + jobId + "]";
	}
	
	
	
	
	
}

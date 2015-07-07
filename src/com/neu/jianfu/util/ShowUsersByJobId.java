package com.neu.jianfu.util;

public class ShowUsersByJobId {
	private String userName;
	private String userSex;
	private String userEdu;
	private String userMaster;
	private String userSkill;
	private String jobName;
	
	public ShowUsersByJobId() {
		
	}
	public ShowUsersByJobId(String userName, String userSex, String userEdu,
			String userMaster, String userSkill) {
		this.userName = userName;
		this.userSex = userSex;
		this.userEdu = userEdu;
		this.userMaster = userMaster;
		this.userSkill = userSkill;
	}
	
	public ShowUsersByJobId(String userName, String userSex, String userEdu,
			String userMaster, String userSkill, String jobName) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.userEdu = userEdu;
		this.userMaster = userMaster;
		this.userSkill = userSkill;
		this.jobName = jobName;
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
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Override
	public String toString() {
		return "ShowUsersByJobId [userName=" + userName + ", userSex="
				+ userSex + ", userEdu=" + userEdu + ", userMaster="
				+ userMaster + ", userSkill=" + userSkill + ", jobName="
				+ jobName + "]";
	}
	
	
	
	
	
}

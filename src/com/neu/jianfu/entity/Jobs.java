package com.neu.jianfu.entity;

public class Jobs {
	
	private Integer jobId;
	private String jobName;
	private String jobDuty;
	private String jobReq;
	private String jobRes;
	private Integer userId;
	
	
	public Jobs() {
		
	}
	
	public Jobs(Integer jobId, String jobName, String jobDuty, String jobReq) {
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDuty = jobDuty;
		this.jobReq = jobReq;
	}

	public Jobs(Integer jobId, String jobName, String jobDuty, String jobReq,
			String jobRes) {
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDuty = jobDuty;
		this.jobReq = jobReq;
		this.jobRes = jobRes;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDuty() {
		return jobDuty;
	}
	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
	}
	public String getJobReq() {
		return jobReq;
	}
	public void setJobReq(String jobReq) {
		this.jobReq = jobReq;
	}
	
	//后加的其他说明
	public String getJobRes() {
		return jobRes;
	}
	public void setJobRes(String jobRes) {
		this.jobRes = jobRes;
	}
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobName=" + jobName + ", jobDuty="
				+ jobDuty + ", jobReq=" + jobReq + ", userId=" + userId + "]";
	}
	
	
	
}

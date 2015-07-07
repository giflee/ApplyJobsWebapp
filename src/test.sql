create table admin(
	adminId number(10) primary key,
	adminName varchar2(50),
	adminPassword varchar2(20)
);

create table jobs(
	jobId number(10) primary key,
	jobName varchar2(50),
	jobDuty varchar2(100),
	jobReq varchar2(100)
);
drop table usersinfo;
drop table jobs;
create table usersinfo(
	userId number(10) primary key,
	userName varchar2(50),
	userSex varchar2(10),
	userEdu varchar2(50),
	userMaster varchar2(50),
	userSkill varchar2(100),
	jobId number(10) references jobs(jobId)
);
insert into admin values('1000','admin','admin');
select userName,userSex,userEdu,userMaster,userSkill from usersinfo,jobs where jobs.jobId =4 and jobs.userId = userinfo.userId;
select * from jobs;

alter table jobs add jobRes varchar2(50);


create sequence userseq0 start with 1
increment by 1
maxvalue 500;

select * from usersinfo;

select username,usersex,useredu,userskill,jobname from jobs,usersinfo where jobs.jobid = 1 and jobs.jobid = usersinfo.jobid;
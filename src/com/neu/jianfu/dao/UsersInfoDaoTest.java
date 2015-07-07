package com.neu.jianfu.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.neu.jianfu.util.ShowUsersByJobId;

public class UsersInfoDaoTest {

	@Test
	public void testFindByJobId() {
		List<ShowUsersByJobId> lists = new ArrayList<ShowUsersByJobId>();
		UsersInfoDao uid = new UsersInfoDao();
		lists = uid.findByJobId(1);
		for(ShowUsersByJobId s : lists){
			System.out.println(s.toString());
		}
	}

}

package com.ccydhz.site.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.dao.UserDao;
import com.ccydhz.site.entity.User;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

	@Override
	public int add(User obj) {
		// TODO Auto-generated method stub
		return super.add(obj);
	}

	@Override
	public User add2(User obj) {
		// TODO Auto-generated method stub
		return super.add2(obj);
	}

	@Override
	public int modify(Map<String, Object> values, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return super.modify(values, condition);
	}
	
	
	

}

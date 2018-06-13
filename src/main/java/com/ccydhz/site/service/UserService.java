package com.ccydhz.site.service;

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

}

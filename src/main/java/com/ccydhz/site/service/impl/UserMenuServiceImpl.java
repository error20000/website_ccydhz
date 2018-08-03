package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.UserMenu;
import com.ccydhz.site.dao.UserMenuDao;
import com.ccydhz.site.service.UserMenuService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class UserMenuServiceImpl extends BaseServiceImpl<UserMenu> implements UserMenuService {

	@Autowired
	private UserMenuDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

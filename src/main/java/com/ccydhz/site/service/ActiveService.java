package com.ccydhz.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.dao.ActiveDao;
import com.ccydhz.site.entity.Active;

@Service
public class ActiveService extends BaseService<Active> {

	@Autowired
	private ActiveDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}


}

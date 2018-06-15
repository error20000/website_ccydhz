package com.ccydhz.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.dao.ActiveTypeDao;
import com.ccydhz.site.entity.ActiveType;

@Service
public class ActiveTypeService extends BaseService<ActiveType> {

	@Autowired
	private ActiveTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}


}

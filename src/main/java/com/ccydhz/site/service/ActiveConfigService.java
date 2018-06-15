package com.ccydhz.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.dao.ActiveConfigDao;
import com.ccydhz.site.entity.ActiveConfig;

@Service
public class ActiveConfigService extends BaseService<ActiveConfig> {

	@Autowired
	private ActiveConfigDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}


}

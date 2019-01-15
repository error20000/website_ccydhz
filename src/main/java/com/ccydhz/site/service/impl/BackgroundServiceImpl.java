package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Background;
import com.ccydhz.site.dao.BackgroundDao;
import com.ccydhz.site.service.BackgroundService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class BackgroundServiceImpl extends BaseServiceImpl<Background> implements BackgroundService {

	@Autowired
	private BackgroundDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Bespeak;
import com.ccydhz.site.dao.BespeakDao;
import com.ccydhz.site.service.BespeakService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class BespeakServiceImpl extends BaseServiceImpl<Bespeak> implements BespeakService {

	@Autowired
	private BespeakDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Other;
import com.ccydhz.site.dao.OtherDao;
import com.ccydhz.site.service.OtherService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class OtherServiceImpl extends BaseServiceImpl<Other> implements OtherService {

	@Autowired
	private OtherDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

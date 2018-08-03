package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Business;
import com.ccydhz.site.dao.BusinessDao;
import com.ccydhz.site.service.BusinessService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements BusinessService {

	@Autowired
	private BusinessDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

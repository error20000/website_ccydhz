package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.BusinessType;
import com.ccydhz.site.dao.BusinessTypeDao;
import com.ccydhz.site.service.BusinessTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class BusinessTypeServiceImpl extends BaseServiceImpl<BusinessType> implements BusinessTypeService {

	@Autowired
	private BusinessTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

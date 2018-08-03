package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ActiveType;
import com.ccydhz.site.dao.ActiveTypeDao;
import com.ccydhz.site.service.ActiveTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ActiveTypeServiceImpl extends BaseServiceImpl<ActiveType> implements ActiveTypeService {

	@Autowired
	private ActiveTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

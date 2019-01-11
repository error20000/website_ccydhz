package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ContactConfig;
import com.ccydhz.site.dao.ContactConfigDao;
import com.ccydhz.site.service.ContactConfigService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ContactConfigServiceImpl extends BaseServiceImpl<ContactConfig> implements ContactConfigService {

	@Autowired
	private ContactConfigDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

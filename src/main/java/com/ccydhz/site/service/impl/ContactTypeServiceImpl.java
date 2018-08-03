package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ContactType;
import com.ccydhz.site.dao.ContactTypeDao;
import com.ccydhz.site.service.ContactTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ContactTypeServiceImpl extends BaseServiceImpl<ContactType> implements ContactTypeService {

	@Autowired
	private ContactTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

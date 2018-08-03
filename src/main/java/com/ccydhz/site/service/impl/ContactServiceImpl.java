package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Contact;
import com.ccydhz.site.dao.ContactDao;
import com.ccydhz.site.service.ContactService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {

	@Autowired
	private ContactDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

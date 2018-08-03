package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ContactLabel;
import com.ccydhz.site.dao.ContactLabelDao;
import com.ccydhz.site.service.ContactLabelService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ContactLabelServiceImpl extends BaseServiceImpl<ContactLabel> implements ContactLabelService {

	@Autowired
	private ContactLabelDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

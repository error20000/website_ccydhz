package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.OtherType;
import com.ccydhz.site.dao.OtherTypeDao;
import com.ccydhz.site.service.OtherTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class OtherTypeServiceImpl extends BaseServiceImpl<OtherType> implements OtherTypeService {

	@Autowired
	private OtherTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

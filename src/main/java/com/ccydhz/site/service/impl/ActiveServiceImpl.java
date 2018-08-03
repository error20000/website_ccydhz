package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Active;
import com.ccydhz.site.dao.ActiveDao;
import com.ccydhz.site.service.ActiveService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ActiveServiceImpl extends BaseServiceImpl<Active> implements ActiveService {

	@Autowired
	private ActiveDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ActiveConfig;
import com.ccydhz.site.dao.ActiveConfigDao;
import com.ccydhz.site.service.ActiveConfigService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ActiveConfigServiceImpl extends BaseServiceImpl<ActiveConfig> implements ActiveConfigService {

	@Autowired
	private ActiveConfigDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

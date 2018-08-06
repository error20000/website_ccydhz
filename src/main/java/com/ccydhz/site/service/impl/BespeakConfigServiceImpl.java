package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.BespeakConfig;
import com.ccydhz.site.dao.BespeakConfigDao;
import com.ccydhz.site.service.BespeakConfigService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class BespeakConfigServiceImpl extends BaseServiceImpl<BespeakConfig> implements BespeakConfigService {

	@Autowired
	private BespeakConfigDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

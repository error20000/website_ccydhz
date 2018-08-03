package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.StrategyType;
import com.ccydhz.site.dao.StrategyTypeDao;
import com.ccydhz.site.service.StrategyTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class StrategyTypeServiceImpl extends BaseServiceImpl<StrategyType> implements StrategyTypeService {

	@Autowired
	private StrategyTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

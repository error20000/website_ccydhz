package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Strategy;
import com.ccydhz.site.dao.StrategyDao;
import com.ccydhz.site.service.StrategyService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class StrategyServiceImpl extends BaseServiceImpl<Strategy> implements StrategyService {

	@Autowired
	private StrategyDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

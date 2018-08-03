package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.HeroesType;
import com.ccydhz.site.dao.HeroesTypeDao;
import com.ccydhz.site.service.HeroesTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class HeroesTypeServiceImpl extends BaseServiceImpl<HeroesType> implements HeroesTypeService {

	@Autowired
	private HeroesTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

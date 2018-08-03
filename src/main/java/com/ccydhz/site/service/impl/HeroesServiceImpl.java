package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Heroes;
import com.ccydhz.site.dao.HeroesDao;
import com.ccydhz.site.service.HeroesService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class HeroesServiceImpl extends BaseServiceImpl<Heroes> implements HeroesService {

	@Autowired
	private HeroesDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

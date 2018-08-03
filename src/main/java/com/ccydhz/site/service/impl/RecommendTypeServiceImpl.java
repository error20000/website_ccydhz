package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.RecommendType;
import com.ccydhz.site.dao.RecommendTypeDao;
import com.ccydhz.site.service.RecommendTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class RecommendTypeServiceImpl extends BaseServiceImpl<RecommendType> implements RecommendTypeService {

	@Autowired
	private RecommendTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

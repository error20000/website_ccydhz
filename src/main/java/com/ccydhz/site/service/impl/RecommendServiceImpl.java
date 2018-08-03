package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Recommend;
import com.ccydhz.site.dao.RecommendDao;
import com.ccydhz.site.service.RecommendService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class RecommendServiceImpl extends BaseServiceImpl<Recommend> implements RecommendService {

	@Autowired
	private RecommendDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

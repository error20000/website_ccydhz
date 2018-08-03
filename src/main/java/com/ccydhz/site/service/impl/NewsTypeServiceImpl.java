package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.NewsType;
import com.ccydhz.site.dao.NewsTypeDao;
import com.ccydhz.site.service.NewsTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class NewsTypeServiceImpl extends BaseServiceImpl<NewsType> implements NewsTypeService {

	@Autowired
	private NewsTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

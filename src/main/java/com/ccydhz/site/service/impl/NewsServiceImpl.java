package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.News;
import com.ccydhz.site.dao.NewsDao;
import com.ccydhz.site.service.NewsService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

	@Autowired
	private NewsDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

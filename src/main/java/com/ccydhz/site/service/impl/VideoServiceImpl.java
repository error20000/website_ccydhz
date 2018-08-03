package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Video;
import com.ccydhz.site.dao.VideoDao;
import com.ccydhz.site.service.VideoService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class VideoServiceImpl extends BaseServiceImpl<Video> implements VideoService {

	@Autowired
	private VideoDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

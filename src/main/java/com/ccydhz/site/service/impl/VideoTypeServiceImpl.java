package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.VideoType;
import com.ccydhz.site.dao.VideoTypeDao;
import com.ccydhz.site.service.VideoTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class VideoTypeServiceImpl extends BaseServiceImpl<VideoType> implements VideoTypeService {

	@Autowired
	private VideoTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

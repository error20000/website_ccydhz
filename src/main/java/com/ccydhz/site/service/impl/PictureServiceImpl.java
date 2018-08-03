package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Picture;
import com.ccydhz.site.dao.PictureDao;
import com.ccydhz.site.service.PictureService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class PictureServiceImpl extends BaseServiceImpl<Picture> implements PictureService {

	@Autowired
	private PictureDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

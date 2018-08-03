package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.PictureType;
import com.ccydhz.site.dao.PictureTypeDao;
import com.ccydhz.site.service.PictureTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class PictureTypeServiceImpl extends BaseServiceImpl<PictureType> implements PictureTypeService {

	@Autowired
	private PictureTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

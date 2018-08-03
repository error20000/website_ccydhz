package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.DownloadType;
import com.ccydhz.site.dao.DownloadTypeDao;
import com.ccydhz.site.service.DownloadTypeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class DownloadTypeServiceImpl extends BaseServiceImpl<DownloadType> implements DownloadTypeService {

	@Autowired
	private DownloadTypeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

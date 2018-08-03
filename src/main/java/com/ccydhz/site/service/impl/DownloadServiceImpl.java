package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Download;
import com.ccydhz.site.dao.DownloadDao;
import com.ccydhz.site.service.DownloadService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class DownloadServiceImpl extends BaseServiceImpl<Download> implements DownloadService {

	@Autowired
	private DownloadDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

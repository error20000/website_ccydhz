package com.ccydhz.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.dao.ShareDao;
import com.ccydhz.site.entity.Share;

@Service
public class ShareService extends BaseService<Share> {

	@Autowired
	private ShareDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}


}

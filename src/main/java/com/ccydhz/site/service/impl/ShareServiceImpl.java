package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Share;
import com.ccydhz.site.dao.ShareDao;
import com.ccydhz.site.service.ShareService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ShareServiceImpl extends BaseServiceImpl<Share> implements ShareService {

	@Autowired
	private ShareDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.ActiveCode;
import com.ccydhz.site.dao.ActiveCodeDao;
import com.ccydhz.site.service.ActiveCodeService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class ActiveCodeServiceImpl extends BaseServiceImpl<ActiveCode> implements ActiveCodeService {

	@Autowired
	private ActiveCodeDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

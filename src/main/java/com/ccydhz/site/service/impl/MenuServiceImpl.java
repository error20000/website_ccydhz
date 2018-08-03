package com.ccydhz.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccydhz.site.entity.Menu;
import com.ccydhz.site.dao.MenuDao;
import com.ccydhz.site.service.MenuService;

/**
 * @author liujian
 * @Date  
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Autowired
	private MenuDao dao;
	
	@Override
	public void initDao() {
		super.baseDao = dao;
	}

}

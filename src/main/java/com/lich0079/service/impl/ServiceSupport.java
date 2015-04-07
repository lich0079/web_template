package com.lich0079.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lich0079.dao.UserDAO;
import com.lich0079.util.BaseLogAble;

/**
 * put all the dao in here
 *
 */
public class ServiceSupport extends BaseLogAble{
	@Autowired
	protected UserDAO userDAO;

}

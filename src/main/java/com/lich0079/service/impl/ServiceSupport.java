package com.lich0079.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.lich0079.dao.UserDAO;
import com.lich0079.util.BaseLogAble;

/**
 * put all the dao in here
 *
 */
@ComponentScan(basePackages="com.lich0079.dao")
public class ServiceSupport extends BaseLogAble{
// 	@Resource(name="userDAOMongoDBImpl")// uncomment this to use mongodb
	@Autowired
	protected UserDAO userDAO;

}

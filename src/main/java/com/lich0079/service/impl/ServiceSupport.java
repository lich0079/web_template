package com.lich0079.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;

import com.lich0079.dao.UserDAO;
import com.lich0079.util.BaseLogAble;

/**
 * put all the dao in here
 *
 */
@ComponentScan(basePackages="com.lich0079.dao")
public class ServiceSupport extends BaseLogAble{
 	@Resource(name="userDAOMongoDBImpl")
	protected UserDAO userDAO;

}

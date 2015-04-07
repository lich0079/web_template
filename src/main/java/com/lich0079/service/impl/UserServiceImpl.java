package com.lich0079.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lich0079.entity.User;
import com.lich0079.service.UserService;

@Service
public class UserServiceImpl extends ServiceSupport implements UserService{

	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}

	public User login(User user) {
		
		return userDAO.login(user);
	}

	public List findUsers(PageBounds pageBounds) {
		
		return userDAO.findUsers(pageBounds);
	}
}

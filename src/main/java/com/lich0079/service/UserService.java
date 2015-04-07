package com.lich0079.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lich0079.entity.User;

public interface UserService {

	public int insertUser(User user);
	public User login(User user);
	public List findUsers(PageBounds pageBounds);
}

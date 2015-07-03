package com.lich0079.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lich0079.entity.User;
public interface UserDAO {

	public int insertUser(User user);
	public User login(User user);
	public List findUsers(PageBounds pageBounds);
	
}

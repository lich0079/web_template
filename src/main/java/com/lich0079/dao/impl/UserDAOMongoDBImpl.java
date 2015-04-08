package com.lich0079.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lich0079.dao.UserDAO;
import com.lich0079.entity.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

@Component("userDAOMongoDBImpl")
public class UserDAOMongoDBImpl implements UserDAO{
	
	@Autowired
	private MongoCollection<User> collection;

	public int insertUser(User user) {
		collection.insertOne(user);
		return 0;
	}

	public User login(User user) {
		return  collection.find(Filters.and(Filters.eq("userName", user.getUserName()), Filters.eq("password", user.getPassword())),User.class).first();
	}

	public List findUsers(PageBounds pageBounds) {
		MongoCursor<User> it= collection.find().iterator();
		List result = new ArrayList();
		try {
		   while(it.hasNext()) {
			   result.add(it.next());
		   }
		} finally {
			it.close();
		}
		return result;
	}

}

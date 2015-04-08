package com.lich0079.entity;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

public class UserCodec implements Codec<User> {

	private Codec<Document> documentCodec;

	public UserCodec() {
		this.documentCodec = new DocumentCodec();
	}

	public UserCodec(Codec<Document> codec) {
		this.documentCodec = codec;
	}

	public void encode(BsonWriter writer, User user,
			EncoderContext encoderContext) {
		Document document = new Document();

		Integer id = user.getUserId();
		String userName = user.getUserName();
		String password = user.getPassword();
		String userRole = user.getUserRole();
		if (id != null) {
			document.put("userId", id);
		}
		if (userName != null) {
			document.put("userName", userName);
		}
		if (password != null) {
			document.put("password", password);
		}
		if (userRole != null) {
			document.put("userRole", userRole);
		}
		documentCodec.encode(writer, document, encoderContext);
	}

	public Class<User> getEncoderClass() {
		return User.class;
	}

	public User decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);

		User user = new User();
		Integer id = document.getInteger("userId");
		user.setUserId(id);
		String userName = (String) document.get("userName");
		user.setUserName(userName);;
		String password = (String) document.get("password");
		user.setPassword(password);
		String userRole = (String) document.get("userRole");
		user.setUserRole(userRole);
		
		return user;
	}

}

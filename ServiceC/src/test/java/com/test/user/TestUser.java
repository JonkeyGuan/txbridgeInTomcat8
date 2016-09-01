package com.test.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.user.domain.User;
import com.test.user.service.UserService;

public class TestUser {

    public static void main(String[] args) {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "client-beans.xml" });

	UserService client = (UserService) context.getBean("user");

	String response = client.ping();
	System.out.println("Response: " + response);

	User user = null;
	try {
	    user = client.getUser("user1");
	} catch (Exception e1) {
	    e1.printStackTrace();
	}
	System.out.println("Response: " + user);

	try {
	    client.updateUser(new User("user1", "name:" + System.currentTimeMillis()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	try {
	    user = client.getUser("user1");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	System.out.println("Response: " + user);

	context.close();
	System.exit(0);
    }

}

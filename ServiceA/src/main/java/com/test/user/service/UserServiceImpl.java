package com.test.user.service;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.user.domain.User;
import com.test.user.mapper.UserMapper;

@WebService(endpointInterface = "com.test.user.service.UserService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("outboundUser")
    private UserService remoteUser;

    public String ping() {
	return "Hi there!";
    }

    @Transactional(readOnly = true)
    public User getUser(String id) {
	return userMapper.findByID(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateUser(User user) {
	log.info("updating local user ...");
	userMapper.updateByID(user);
	log.info("updated.");

	log.info("updating remote user ...");
	remoteUser.updateUser(user);
	log.info("updated.");
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(User user) {
	log.info("adding local user ...");
//	userMapper.add(user);
	log.info("added");

	log.info("adding remote user ...");
	remoteUser.addUser(user);
	log.info("added");
    }

}
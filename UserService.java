package org.codejudge.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	FollowersRepository followersRepository;

	public Userr fetchUser(String username) {
		Userr found = userRepository.findByUsername(username);
		if (found == null)
			throw new UserNotFoundException("user does not exist");
		return found;
	}

	public Userr createUser(Userr user) {
		return userRepository.save(user);
	}

	public StatusResponse deleteUser(String username) {
		try {
			userRepository.delete(username);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException(e.getMessage());
		}
		return new StatusResponse("success");
	}

	public StatusResponse followUser(String followedBy, String following) {
		Userr from = userRepository.findOne(followedBy);
		Userr to = userRepository.findOne(following);
		if (from != null && to != null) {
			followersRepository.save(new Followers(from, to));
			return new StatusResponse("success");
		} else {
			throw new UserNotFoundException("user(s) doesn't exist!");
		}
	}

	public StatusResponse updateUser(Userr user, String username) {
		
		Userr existing = userRepository.findOne(username);
		if (existing != null) deleteUser(username);
		existing.setUsername(user.username);
		userRepository.save(existing);
		return new StatusResponse("success");
	}

}

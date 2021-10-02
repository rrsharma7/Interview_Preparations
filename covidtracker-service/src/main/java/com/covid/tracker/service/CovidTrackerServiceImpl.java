package com.covid.tracker.service;

import org.springframework.stereotype.Service;

import com.covid.tracker.domain.entity.User;
import com.covid.tracker.domain.model.RegisterUserReq;
import com.covid.tracker.domain.model.RegisterUserResp;
import com.covid.tracker.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CovidTrackerServiceImpl implements CovidTrackerService {

	private UserRepository userRepo;

	public CovidTrackerServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public RegisterUserResp registerUser(RegisterUserReq request) {
		User user=new User(request.getName(),request.getPhoneNumber(),request.getPinCode());
		System.out.println("user="+user.toString());
		userRepo.save(user);
		Iterable<User> userList=userRepo.findAll();
		User dbUser=userList.iterator().next();	
		RegisterUserResp response=new RegisterUserResp();
		response.setUserId(String.valueOf(dbUser.getId()));
		return response;
				
	}

}

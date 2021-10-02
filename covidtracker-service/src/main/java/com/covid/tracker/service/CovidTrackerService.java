package com.covid.tracker.service;

import com.covid.tracker.domain.model.RegisterUserReq;
import com.covid.tracker.domain.model.RegisterUserResp;

public interface CovidTrackerService {

	RegisterUserResp registerUser(RegisterUserReq request);
}

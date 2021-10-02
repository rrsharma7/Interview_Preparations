package com.covid.tracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.tracker.domain.model.RegisterUserReq;
import com.covid.tracker.domain.model.RegisterUserResp;
import com.covid.tracker.domain.model.SelfAssessmentReq;
import com.covid.tracker.exception.ValidationException;
import com.covid.tracker.service.CovidTrackerService;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
@RequestMapping("/api")
public class CovidTrackerController {

	private static final String MANDATORY_PARAMERTES_ARE_MISSING = "Mandatory Paramertes are missing";
	private CovidTrackerService covidTrackerService;

	public CovidTrackerController(CovidTrackerService covidTrackerService) {
		this.covidTrackerService = covidTrackerService;
	}

	@PostMapping("/registerUser")
	public ResponseEntity<RegisterUserResp> registerUser(@RequestBody RegisterUserReq request)
			throws ValidationException {
		if (null == request || StringUtils.isEmpty(request.getName()) || StringUtils.isEmpty(request.getPhoneNumber())
				|| StringUtils.isEmpty(request.getPinCode())) {
			throw new ValidationException(MANDATORY_PARAMERTES_ARE_MISSING);
		}
		RegisterUserResp response = covidTrackerService.registerUser(request);
		return new ResponseEntity<RegisterUserResp>(response, HttpStatus.OK);

	}

//	@PostMapping("/registerUser")
//	public ResponseEntity<RegisterUserResp> selfAssessment(@RequestBody SelfAssessmentReq request)
//			throws ValidationException {
////		if (null == request || StringUtils.isEmpty(request.getName()) || StringUtils.isEmpty(request.getPhoneNumber())
////				|| StringUtils.isEmpty(request.getPinCode())) {
////			throw new ValidationException(MANDATORY_PARAMERTES_ARE_MISSING);
////		}
//		RegisterUserResp response = covidTrackerService.selfAssessment(request);
//		return new ResponseEntity<RegisterUserResp>(response, HttpStatus.OK);
//
//	}
	

}

//Sample request - {"userId":"1","symptoms":["fever","cold","cough"],"travelHistory":true,"contactWithCovidPatient":true}
//Sample response - {"riskPercentage": 95}

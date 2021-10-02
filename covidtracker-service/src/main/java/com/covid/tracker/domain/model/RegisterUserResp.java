package com.covid.tracker.domain.model;

import java.io.Serializable;


public class RegisterUserResp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6368744705455011524L;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}

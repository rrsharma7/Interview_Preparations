package com.covid.tracker.domain.model;

import java.io.Serializable;

public class RegisterUserReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8595749668709082977L;
	private String name;
	private String phoneNumber;
	private String pinCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}

package com.covid.tracker.domain.model;

import java.io.Serializable;
import java.util.List;


public class SelfAssessmentReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 850251799978032266L;
	public String userId;
	public List<String> symptoms;
	public boolean travelHistory;
	public boolean contactWithCovidPatient;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(boolean travelHistory) {
		this.travelHistory = travelHistory;
	}

	public boolean isContactWithCovidPatient() {
		return contactWithCovidPatient;
	}

	public void setContactWithCovidPatient(boolean contactWithCovidPatient) {
		this.contactWithCovidPatient = contactWithCovidPatient;
	}

}

package com.aeongo.packagemanagementsystem.service;

public interface ValidationService {
	
	public Boolean accessTokenVerification(Integer patientId, String access_token);

}

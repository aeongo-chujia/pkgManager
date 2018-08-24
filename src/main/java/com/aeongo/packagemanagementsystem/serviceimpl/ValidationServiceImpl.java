package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aeongo.packagemanagementsystem.response.ValidationResponse;
import com.aeongo.packagemanagementsystem.service.ValidationService;


@Service
public class ValidationServiceImpl implements ValidationService {

private RestTemplate restTemplate;
	
	@Value(value="${emraccesstokenurl}") 
	private String emrAccessTokenUrl;
	
	@Override
	public Boolean accessTokenVerification(Integer patientId, String access_token) {
		String request = emrAccessTokenUrl + "?patient_id=" + patientId + "&access_token=" + access_token;
		ValidationResponse result = restTemplate.getForObject(request, ValidationResponse.class);
		return result.getStatus() == 0;
	}

}

package com.aeongo.packagemanagementsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
//import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse;
@Service
public interface EmrInformationService {
	
	public Integer getPatientAgeByYear(Integer patientId);
	public Integer getPatientAgeByDay(Integer patientId);
	public List<RecommendationRequest.ActorTag> getTagsByPatient(Integer patientId);
	public List<RecommendationRequest.ActorTag> getTagsByDoctor(Integer doctorId);
	public List<Integer> getAssociatedDoctorsByPatient(Integer patientId);
	public String getDoctorName(Integer doctorId);
	//public DoctorInfoResponse getDoctorInfo(Integer doctorId);
	public Boolean VerifyDoctorExistence(Integer doctorId);
	
}

package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest.ActorTag;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
@Service
public class EmrInformationServiceImpl implements EmrInformationService {

	@Override
	public Integer getPatientAgeByYear(Integer patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPatientAgeByDay(Integer patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActorTag> getTagsByPatient(Integer patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActorTag> getTagsByDoctor(Integer doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getAssociatedDoctorsByPatient(Integer patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDoctorName(Integer doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean VerifyDoctorExistence(Integer doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

}

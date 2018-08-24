package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse;
import com.aeongo.packagemanagementsystem.response.PatientInfoResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;


@Service
public class EmrInformationServiceImpl implements EmrInformationService {

	private RestTemplate restTemplate;
	
	@Value(value="${emrpatienturl}") 
	private String emrpatientUrl;
	
	@Value(value="${emrdoctorturl}") 
	private String emrdoctortUrl;
	
	public EmrInformationServiceImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	
	@Override
	public Integer getPatientAgeByYear(Integer patientId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			birthday = sdf.parse(this.getPatientInfo(patientId).getData().getBirthday());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Date format error");
		}
		Date now = new Date();
		return (int) ((now.getTime() - birthday.getTime()) / (1000 * 60 * 60 * 24 * 365));
	}

	@Override
	public Integer getPatientAgeByDay(Integer patientId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			birthday = sdf.parse(this.getPatientInfo(patientId).getData().getBirthday());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Date format error");
		}
		Date now = new Date();
		return (int) ((now.getTime() - birthday.getTime()) / (1000 * 60 * 60 * 24));
	}

	@Override
	public List<RecommendationRequest.ActorTag> getTagsByPatient(Integer patientId) {
		List<RecommendationRequest.ActorTag> tags = new ArrayList<>();
		this.getPatientInfo(patientId).getData().getHealth_tags().stream().forEach(tag -> {
			RecommendationRequest.ActorTag tag1 = new RecommendationRequest.ActorTag();
			tag1.setActorTagCategory("tag");
			tag1.setActorTagValue(tag.getName());
			tags.add(tag1);
		});
		return tags;
	}

	@Override
	public List<RecommendationRequest.ActorTag> getTagsByDoctor(Integer doctorId) {
		List<RecommendationRequest.ActorTag> tags = new ArrayList<>();
		this.getDoctorInfo(doctorId).getData().getAdept_tags().stream().forEach(tag -> {
			RecommendationRequest.ActorTag tag1 = new RecommendationRequest.ActorTag();
			tag1.setActorTagCategory("tag");
			tag1.setActorTagValue(tag.getName());
			tags.add(tag1);
		});
		return tags;
	}

	@Override
	public List<Integer> getAssociatedDoctorsByPatient(Integer patientId) {
		return this.getPatientInfo(patientId).getData().getDoctor_ids();
	}

	@Override
	public String getDoctorName(Integer doctorId) {
		return this.getDoctorInfo(doctorId).getData().getFullname();
	}


	@Override
	public DoctorInfoResponse getDoctorInfo(Integer doctorId) {
		Map<String, Integer> request = new HashMap<>();
		request.put("doctor_id", doctorId);
		DoctorInfoResponse result = restTemplate.getForObject(emrdoctortUrl, DoctorInfoResponse.class, request);
		return result;
	}


	@Override
	public Boolean VerifyDoctorExistence(Integer doctorId) {
		return this.getDoctorInfo(doctorId).getData() != null;
	}


	@Override
	public PatientInfoResponse getPatientInfo(Integer patientId) {
		Map<String, Integer> request = new HashMap<>();
		request.put("patient_id", patientId);
		PatientInfoResponse result = restTemplate.getForObject(emrdoctortUrl, PatientInfoResponse.class, request);
		return result;
	}
	
	

}

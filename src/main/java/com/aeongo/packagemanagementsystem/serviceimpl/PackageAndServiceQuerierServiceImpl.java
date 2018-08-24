package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.dao.DoctorOptoffDao;
import com.aeongo.packagemanagementsystem.dao.PackageDao;
import com.aeongo.packagemanagementsystem.dao.PatientPurchasePackageInfoDao;
import com.aeongo.packagemanagementsystem.dao.ServiceDao;
import com.aeongo.packagemanagementsystem.entity.DoctorOptoff;
import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;
import com.aeongo.packagemanagementsystem.exception.ValidationFailedException;
import com.aeongo.packagemanagementsystem.request.RecommendationRequest.ActorTag;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceQuerierService;
import com.aeongo.packagemanagementsystem.service.RecommendationService;
import com.aeongo.packagemanagementsystem.service.ValidationService;


@Service
public class PackageAndServiceQuerierServiceImpl implements PackageAndServiceQuerierService {

	private ServiceDao serviceDao;
	
	private PackageDao packageDao;

	private PatientPurchasePackageInfoDao patientPurchasePackageInfoDao;
	
	private DoctorOptoffDao doctorOptoffDao;
	
	private EmrInformationService emrInformationService;
	
	private RecommendationService recommendationService;
	
	private ValidationService validationService;
	
	
	@Autowired
	public PackageAndServiceQuerierServiceImpl(ServiceDao serviceDao, PackageDao packageDao, PatientPurchasePackageInfoDao patientPurchasePackageInfoDao,
			DoctorOptoffDao doctorOptoffDao, RecommendationService recommendationService, EmrInformationService emrInformationService,ValidationService validationService) {
		this.serviceDao = serviceDao;
		this.packageDao = packageDao;
		this.patientPurchasePackageInfoDao = patientPurchasePackageInfoDao;
		this.doctorOptoffDao = doctorOptoffDao;
		this.recommendationService = recommendationService;
		this.emrInformationService = emrInformationService;
		this.validationService = validationService;
	}
	
	
	
	@Override
	public List<PackageResponse> getPackageByDoctor(Integer patientId, Integer doctorId, String access_token) {
		
		//The content of the response
		List<PackageResponse> doctorPackagesResponse = new ArrayList<>();
		
		
		//1.Validate the input data
		//1.1.validate the patientId and access_token
		//1.2.validate the doctor's existence
		if(!this.validationService.accessTokenVerification(patientId, access_token)) {
			throw new ValidationFailedException("Access Denied");
		}else if(!this.emrInformationService.VerifyDoctorExistence(doctorId)) {
			throw new ValidationFailedException("The doctor doesn't exist");
		}
		
		
		//2.Get free packages and set into the response
		List<PatientPurchasePackageInfo> freePackages = patientPurchasePackageInfoDao.findByFree();
		freePackages.stream().forEach(packageEntry -> {
			PackageResponse recommendation = new PackageResponse();
			recommendation.setPackageId(packageEntry.getPackageId()+"");
			recommendation.setTitle(packageEntry.getPackageName());
			recommendation.setSubtitle("适用范围: " + packageEntry.getAgeRange());
			recommendation.setShortDescription(packageEntry.getShortDescription());
			recommendation.setAction("查看");
			recommendation.setActionIcon("/pic/rightArrow");
			recommendation.setPicture(packageEntry.getPicture());
			doctorPackagesResponse.add(recommendation);
		});

		
		//3.Get recommended packages based on the matched tags from the patient and the doctor
		//3.1.Get patient's tags from EMR.
		////List<ActorTag> patientTags = emrInformationService.getTagsByPatient(patientId);
		List<ActorTag> patientTags = new ArrayList<>();
		patientTags.add(new ActorTag("tag", "preterm"));
		
		//3.2.Get doctor's tags from EMR.
		////List<ActorTag> doctorTags = emrInformationService.getTagsByDoctor(doctorId);
		List<ActorTag> doctorTags = new ArrayList<>();
		doctorTags.add(new ActorTag("tag", "preterm"));
		doctorTags.add(new ActorTag("tag", "jaundice"));
		
		//3.3.Match tags
		List<ActorTag> matchedTags = new ArrayList<>();
		if (patientTags.size() >= doctorTags.size()) {
			Integer size = doctorTags.size();
			for(int i=0;i<size;i++) {
				ActorTag tag = doctorTags.get(i);
				if(patientTags.contains(tag)) {
					matchedTags.add(tag);
				}
			}
		}else {
			Integer size = patientTags.size();
			for(int i=0;i<size;i++) {
				ActorTag tag = patientTags.get(i);
				if(doctorTags.contains(tag)) {
					matchedTags.add(tag);
				}
			}
		}
		
		
		//3.4.Use matched tags to get recommended packages from the recommendation system
		////List<Integer> rawRecommendedPackageIds = recommendationService.getRecommendationPackagesByTags(matchedTags);
		////List<Integer> recommendedPackageIds = new CopyOnWriteArrayList<>(rawRecommendedPackageIds);
		List<Integer> recommendedPackageIds = new CopyOnWriteArrayList<>();
		recommendedPackageIds.add(2);
		recommendedPackageIds.add(3);
		
		//3.5.Minus the doctor's optoff packages
		////List<DoctorOptoff> optoffs = doctorOptoffDao.findAllByDoctorId(doctorId);
		////List<Integer> optoffPackageIds = optoffs.stream().map(optoff -> optoff.getPackageId()).collect(Collectors.toList());
		List<Integer> optoffPackageIds = new ArrayList<>();
		optoffPackageIds.add(2);
		
		
		for(Integer packageId : recommendedPackageIds) {
			if(optoffPackageIds.contains(packageId)) {
				recommendedPackageIds.remove(packageId);
			}
		}
		
		//3.6.Get package objects from the db
		List<com.aeongo.packagemanagementsystem.entity.Package> recommendedPackages = packageDao.findAllById(recommendedPackageIds);
		
		
		//3.7.Set the data into response
		recommendedPackages.stream().forEach(packageEntry -> {
			PackageResponse recommendation = new PackageResponse();
			recommendation.setPackageId(packageEntry.getPackageId()+"");
			recommendation.setTitle(packageEntry.getPackageName());
			recommendation.setSubtitle("适用范围: " + packageEntry.getAgeRange());
			recommendation.setShortDescription(packageEntry.getShortDescription());
			recommendation.setAction("查看");
			recommendation.setActionIcon("/pic/rightArrow");
			recommendation.setPicture(packageEntry.getPicture());
			doctorPackagesResponse.add(recommendation);
		});
	
		return doctorPackagesResponse;
	}

	
}

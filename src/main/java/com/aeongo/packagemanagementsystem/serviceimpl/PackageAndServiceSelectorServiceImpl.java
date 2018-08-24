package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;
import com.aeongo.packagemanagementsystem.service.RecommendationService;
import com.aeongo.packagemanagementsystem.service.ValidationService;



@Service
public class PackageAndServiceSelectorServiceImpl implements PackageAndServiceSelectorService{
	
	private ServiceDao serviceDao;
	
	private PackageDao packageDao;

	private PatientPurchasePackageInfoDao patientPurchasePackageInfoDao;
	
	private DoctorOptoffDao doctorOptoffDao;
	
	private EmrInformationService emrInformationService;
	
	private RecommendationService recommendationService;
	
	private ValidationService validationService;
	
	
	@Autowired
	public PackageAndServiceSelectorServiceImpl(ServiceDao serviceDao, PackageDao packageDao, PatientPurchasePackageInfoDao patientPurchasePackageInfoDao,
			DoctorOptoffDao doctorOptoffDao, RecommendationService recommendationService, EmrInformationService emrInformationService,ValidationService validationService) {
		this.serviceDao = serviceDao;
		this.packageDao = packageDao;
		this.patientPurchasePackageInfoDao = patientPurchasePackageInfoDao;
		this.doctorOptoffDao = doctorOptoffDao;
		this.recommendationService = recommendationService;
		this.emrInformationService = emrInformationService;
		this.validationService = validationService;
	}
	
	
	/** 
	* @Title: Mental Health Service Selector
	* @Description: Select mental health services based on the patientId
	* @author Sun
	*/
	public ServiceSelectorResponse mentalHealthServiceSelectorService(Integer patientId) {
		
		//1.call patient profile api to get the patient's age.
		Integer age = 4;
		
		//2.call patient medical records api to get the patient's preexisting condition.
		String precondition = "diabetes";
		
		//3.use the model to get the recommended services.
		//List<RecommendationModel> recommendations = this.generalServiceOrPackageSelector(patientId, age, precondition, "serviceSelector");
		
		//4.retrieve the recommended services information from db and wrap it into the response.
//		List<Service> services = new ArrayList<>();
//		recommendations.stream().map(recommendation -> recommendation.getItemId()).forEach((itemId) -> {
//			itemId = itemId.substring(7);
//			Service service = serviceDao.findById(Integer.parseInt(itemId));
//			services.add(service);
//		});
		
		//5.call user behavior api to get the paid services
		
		//6.add paid services into the response
		
		return null;
	}
	
	
	
	
	/** 
	* @Title: Package Selector
	* @Description: Select packages based on patientId and doctorId
	* @author Sun
	*/
	public PackageSelectorResponse packageSelectorService(Integer patientId, String access_token) {
		
		
		//1.Validate the patientId and access_token
//		if(this.validationService.accessTokenVerification(patientId, access_token)) {
//			throw new ValidationFailedException("Access Denied");
//		}
		
		
		//The content of the response
		List<PackageSelectorResponse.Package> recommendedPackagesResponse = new ArrayList<>();

		//2.Get purchased packages and set into the response
		List<PatientPurchasePackageInfo> purchased = patientPurchasePackageInfoDao.findByPatient(patientId);
		List<Integer> pruchasedPackageIds = new ArrayList<>();
		purchased.stream().forEach(purchasedPackage -> {
			PackageSelectorResponse.Package recommendation = new PackageSelectorResponse.Package();
			pruchasedPackageIds.add(purchasedPackage.getPackageId());
			recommendation.setPackageId(purchasedPackage.getPackageId()+"");
			recommendation.setTitle(purchasedPackage.getPackageName());
			recommendation.setSubtitle("");
			recommendation.setShortDescription(purchasedPackage.getShortDescription());
			recommendation.setAction("查看");
			recommendation.setPurchaseStatus("Paid");
			recommendation.setPicture(purchasedPackage.getPicture());
			//recommendation.setFootnote(emrInformationService.getDoctorName(purchasedPackage.getDoctorId()));
			recommendation.setFootnote(purchasedPackage.getDoctorId()+"");
			recommendedPackagesResponse.add(recommendation);
		});
		
		//3.Get recommended packages
		//3.1.Get patient age from EMR.
		RecommendationRequest.ActorTag patientAge = new RecommendationRequest.ActorTag();
		patientAge.setActorTagCategory("age");
		patientAge.setActorTagValue("" + emrInformationService.getPatientAgeByDay(patientId));

		
		//3.2.Get patient tags from EMR.
		////List<RecommendationRequest.actorTag> patientTag = emrInformationService.getTagsByPatient(patientId);
		////patientTag.add(patientAge);
		
		//3.3.Get the recommended packageIds based on the patient's tags.
		////List<Integer> recommendedPackagesByPatient = recommendationService.getRecommendationPackagesByTags(patientTag);
		List<Integer> recommendedPackagesByPatient = new CopyOnWriteArrayList<>();
		recommendedPackagesByPatient.add(1);
		recommendedPackagesByPatient.add(2);
		recommendedPackagesByPatient.add(3);
		recommendedPackagesByPatient.add(4);
		
		//3.4.Recommended packages should minus already purchased packages
		for(Integer packageId: recommendedPackagesByPatient) {
			if(pruchasedPackageIds.contains(packageId)) {
				recommendedPackagesByPatient.remove(packageId);
			}
		}
		
		//3.5.Get all recommended package objects from the db
		List<com.aeongo.packagemanagementsystem.entity.Package> recommendedPackages = new ArrayList<>();
		for(Integer packageId :recommendedPackagesByPatient) {
			recommendedPackages.add(packageDao.findById(packageId));
		}
		
		
		//3.6.Get patient associated doctors from EMR(already sorted by associate date).
		////List<Integer> associatedDoctor = emrInformationService.getAssociatedDoctorsByPatient(patientId);
		List<Integer> associatedDoctor = new ArrayList<>();
		associatedDoctor.add(1);
		
		//3.7.Get doctor recommended packages, if the packageId match the patient's recommended packages and not opted off by the doctor,
		//add the doctor name and the package information into response. Then delete the packageId in the patient recommendation list.
		//PackageSelectorResponse recommendedPackagesResponse = new PackageSelectorResponse();
		
		//loop from associated doctors
		associatedDoctor.stream().forEach(doctorId -> {
			//get doctor name
			////String doctorName = emrInformationService.getDoctorName(doctorId);
			String doctorName = "Jack";
			//get doctor tags
			////List<RecommendationRequest.actorTag> doctorTags = emrInformationService.getTagsByDoctor(doctorId);
			//get recommended packages for the doctor based on his tags
			////List<Integer> doctorPackages = recommendationService.getRecommendationPackagesByTags(doctorTags);
			List<Integer> doctorPackages = new ArrayList<>();
			doctorPackages.add(1);
			doctorPackages.add(2);
			doctorPackages.add(3);
			//get doctor optoff packages
			List<DoctorOptoff> optoffs = doctorOptoffDao.findAllByDoctorId(doctorId);
			List<Integer> optoffPackageIds = optoffs.stream().map(optoff -> optoff.getPackageId()).collect(Collectors.toList());
			
			//loop recommended packages for the doctor
			for(Integer packageId : doctorPackages) {
				//check if the package in the recommended packages for the patient and not opted off by the doctor
				if(recommendedPackagesByPatient.contains(packageId) && !optoffPackageIds.contains(packageId)) {
					PackageSelectorResponse.Package recommendation = new PackageSelectorResponse.Package();
					com.aeongo.packagemanagementsystem.entity.Package packageEntry = recommendedPackages.get(recommendedPackagesByPatient.indexOf(packageId));
					recommendation.setPackageId(packageId+"");
					recommendation.setTitle(packageEntry.getPackageName());
					recommendation.setSubtitle("");
					recommendation.setShortDescription(packageEntry.getShortDescription());
					recommendation.setAction("查看");
					recommendation.setPurchaseStatus("NeedToPay");
					recommendation.setPicture(packageEntry.getPicture());
					recommendation.setFootnote(doctorName);
					recommendedPackagesResponse.add(recommendation);
					recommendedPackagesByPatient.remove(packageId);
					recommendedPackages.remove(packageEntry);
				}
			}
		});
		
		
		//3.8.For the remaining of patient recommendation package list,add default doctor name and set into the response.
 		for(Integer packageId : recommendedPackagesByPatient) {
			PackageSelectorResponse.Package recommendation = new PackageSelectorResponse.Package();
			com.aeongo.packagemanagementsystem.entity.Package packageEntry = recommendedPackages.get(recommendedPackagesByPatient.indexOf(packageId));
			recommendation.setPackageId(packageId+"");
			recommendation.setTitle(packageEntry.getPackageName());
			recommendation.setSubtitle("");
			recommendation.setShortDescription(packageEntry.getShortDescription());
			recommendation.setAction("查看");
			recommendation.setPurchaseStatus("NeedToPay");
			recommendation.setPicture(packageEntry.getPicture());
			recommendation.setFootnote("Default Doctor");
			recommendedPackagesResponse.add(recommendation);
		}
		
		
		//4.Set into the response 
		PackageSelectorResponse response = new PackageSelectorResponse();
		response.setPackages(recommendedPackagesResponse);
		
		return response;
	}

}

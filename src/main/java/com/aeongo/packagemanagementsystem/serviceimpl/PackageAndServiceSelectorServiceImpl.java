package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aeongo.packagemanagementsystem.dao.PackageDao;
import com.aeongo.packagemanagementsystem.dao.PkgMngDao;
import com.aeongo.packagemanagementsystem.dao.ServiceDao;
import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;



@org.springframework.stereotype.Service
public class PackageAndServiceSelectorServiceImpl implements PackageAndServiceSelectorService{
	
	
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private PackageDao packageDao;
	
	@Autowired PkgMngDao pkgMngDao;
	
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
	public PackageSelectorResponse packageSelectorService(Integer patientId,Integer doctorId) {
		
		//1.call patient profile api to get the patient's age.
		Integer age = 1;
				
		//2.call patient medical records api to get the patient's preexisting condition.
		String precondition = "diabetes";
		
		//3.use the model to get the recommended services.
//		List<RecommendationModel> recommendations = this.generalServiceOrPackageSelector(patientId, age, precondition, "packageSelector");
//		
//		//4.retrieve the services information from db and wrap it into the response.
//		List<com.aeongo.recommendationsystem.entity.Package> packages = new ArrayList<>();
//		Date expirationDate = new Date();
//		recommendations.stream().map(recommendation -> recommendation.getItemId()).forEach((itemId) -> {
//			itemId = itemId.substring(7);
//			com.aeongo.recommendationsystem.entity.Package package1 = packageDao.findById(Integer.parseInt(itemId));
//			packages.add(package1);
//		});
				
		
		//5.call user behavior api to get the paid packages
		
		//6.add paid packages into the response
		
		//return new PackageSelectorResponse(packages, expirationDate);
		return null;
	}
	public PackageResponse packageDetailInfo(Integer packageId, Integer patientId, Integer doctorId) {
		PackageResponse res = new PackageResponse();
		List<PackageInfo> packageInfos = pkgMngDao.getPackageInfo(packageId,doctorId);
		List<Integer> packagePlans = pkgMngDao.getPlanIdsByPackageId(packageId);
		List<PlanUsage> purchasedPlans = pkgMngDao.getPurchasedPlans(doctorId, patientId, packagePlans);
		
		return res;
	}
}

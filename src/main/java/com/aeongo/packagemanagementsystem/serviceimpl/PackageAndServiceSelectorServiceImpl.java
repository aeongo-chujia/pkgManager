package com.aeongo.packagemanagementsystem.serviceimpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.aeongo.packagemanagementsystem.dao.PackageDao;
import com.aeongo.packagemanagementsystem.dao.PkgMngDao;
import com.aeongo.packagemanagementsystem.dao.ServiceDao;
import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;
import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.entity.ServicePrivilege;
import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;
import com.aeongo.packagemanagementsystem.service.RecommendationService;



@org.springframework.stereotype.Service
public class PackageAndServiceSelectorServiceImpl implements PackageAndServiceSelectorService{
	
	
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private PackageDao packageDao;
	
	@Autowired 
	PkgMngDao pkgMngDao;
	
	@Autowired
	EmrInformationService emrInformationService;
	
	@Autowired
	RecommendationService recommendationService;
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
	@Override
	public ServiceSelectorResponse physicalHealthSelectorService(Integer patientId) {
		ServiceSelectorResponse res = new ServiceSelectorResponse();
		Integer patientAge  = emrInformationService.getPatientAgeByDay(patientId);
		List<RecommendationRequest.ActorTag> tags = emrInformationService.getTagsByPatient(patientId);
		List<Integer> serviceIds = new ArrayList<>();//recommendationService.getRecommendationServicesByTags(tags);
		serviceIds.add(1);
		serviceIds.add(3);
		serviceIds.add(2);
		List<Service> services = pkgMngDao.findAllServicesById(serviceIds);
		for (Service s:services) {
			System.out.println("fufffff:"+s);
			List<ServicePrivilege> privileges = pkgMngDao.findPrivilegesByServiceId(s.getServiceId());
			List<Integer> pIds = new ArrayList<>();
			List<String> pNames = new ArrayList<>();
			for (ServicePrivilege p:privileges) {
				pIds.add(p.getPrivilegeId());
				pNames.add(p.getPrivilegeName());
			}
			res.addService(s.getServiceId(), s.getServiceName(), s.getDescription(), s.getShortDescription(), s.getPicture(), s.getServiceType(), s.getServiceDisplayPriority(), pIds, pNames);
		}
		return res;
	}
	@Override
	public int UpdateServiceUsage(Integer patientId, Integer doctorId, Integer planId, Integer serviceId) {
		Date date = new Date();
		pkgMngDao.saveServiceUsage(patientId, doctorId, planId, serviceId,new Timestamp(date.getTime()));
		PlanUsage record = pkgMngDao.getPlanUsage(patientId, doctorId, planId, serviceId);
		System.out.println("Check:"+record.toString());
		record.setServiceUsed(record.getServiceUsed()+1);
		pkgMngDao.savePlanUsage(record);
		return 0;
	}
	@Override
	public PackageResponse packageDetailInfo(Integer packageId, Integer patientId, Integer doctorId) {
		System.out.println("input parameter:"+packageId+'&'+patientId+'&'+doctorId);
		PackageResponse res = new PackageResponse();
		//List<PackageInfo> packageInfos = new ArrayList<>();
		List<PackageInfo> packageInfos = pkgMngDao.getPackageInfo(packageId,doctorId);
		List<Plan> packagePlans = pkgMngDao.getPlansByPackageId(packageId);
		List<Integer> plans = new ArrayList<>();
		for (Plan p:packagePlans) {
			plans.add(p.getPlanId());
		}
		System.out.println("Repository data - plans:" + plans.toString());
		List<PlanUsage> purchasedPlans = pkgMngDao.getPurchasedPlans(doctorId, patientId, plans);
		System.out.println("Repository data - packageInfos:" + packageInfos.toString());
		System.out.println("Repository data - purchasedPlans:" + purchasedPlans.toString());
		if (packageInfos.isEmpty()) return res;
		PackageInfo first = packageInfos.get(0);
		res.setTitle(first.getPkgName());
		res.setDescription(first.getPkgDescription());
		res.setShortDescription(first.getPkgShotdesc());
		res.setPicture(first.getPkgPicture());
		HashMap<Integer,List<PlanUsage>> usageRecords = new HashMap<>();
		HashMap<Integer,List<PackageInfo>> purchasedRecords = new HashMap<>();
		HashMap<Integer,List<PackageInfo>> unpurchasedRecords = new HashMap<>();
		for (PlanUsage use: purchasedPlans) {
			if (!usageRecords.containsKey(use.getPlanId())) {
				List<PlanUsage> list = new ArrayList<>();
				list.add(use);
				usageRecords.put(use.getPlanId(), list);
			}
			else
				usageRecords.get(use.getPlanId()).add(use);
		}
		for (PackageInfo info:packageInfos) {
			if (usageRecords.containsKey(info.getPlanId())) {
				if (purchasedRecords.containsKey(info.getPlanId())) {
					purchasedRecords.get(info.getPlanId()).add(info);
				}
				else {
					List<PackageInfo> list = new ArrayList<>();
					list.add(info);
					purchasedRecords.put(info.getPlanId(), list);
				}
			}
			else {
				if (unpurchasedRecords.containsKey(info.getPlanId())) {
					unpurchasedRecords.get(info.getPlanId()).add(info);
				}
				else {
					List<PackageInfo> list = new ArrayList<>();
					list.add(info);
					unpurchasedRecords.put(info.getPlanId(), list);
				}
			}
		}
		for (Entry<Integer, List<PackageInfo>> info:purchasedRecords.entrySet()) {
			if (info.getValue().isEmpty()) continue;
			List<PlanUsage> record = usageRecords.get(info.getKey());
			String current = info.getValue().get(0).getPlanName();
			String picture = info.getValue().get(0).getPlanPicture();
			Timestamp expiration = record.get(0).getEndDate();
			String remaining = "";
			for (PlanUsage use: record) {
				if (use.getServiceLimist()==null) continue;
				String Name = "";
				for (PackageInfo temp:info.getValue()) {
					if (temp.getServiceId()==use.getServiceId()) {
						Name = temp.getServiceName();
						break;
					}
				}
				if (remaining!="") remaining = remaining + "  ";
				remaining = remaining + "Service: "+Name+" Remaining: "+(use.getServiceLimist()-use.getServiceUsed());
			}
			res.addCurrentPlan(info.getKey(), current, expiration, remaining, picture);
		}
		for (Entry<Integer, List<PackageInfo>> info:unpurchasedRecords.entrySet()) {
			if(info.getValue().isEmpty()) continue;
			List<PackageInfo> record = info.getValue();
			String title = record.get(0).getPlanName();
			String description = record.get(0).getPlanDescription();
			String subtitle = record.get(0).getDuration().toString();
			String shortDescription = record.get(0).getPlanShotdesc();
			String picture = record.get(0).getPlanPicture();
			String action = "purchase";
			BigDecimal price = new BigDecimal(0);
			for (PackageInfo temp:record) {
				if (temp.getQuantity()==null||temp.getUnitPrice()==null) continue;
				price = price.add(temp.getUnitPrice().multiply(BigDecimal.valueOf(temp.getQuantity())));
			}
			price = price.add(record.get(0).getBasePrice());
			String footnote = ""+(price.add(BigDecimal.valueOf(200))).toString();
			res.addPlan(info.getKey(), title, description, subtitle, shortDescription, picture, footnote, action, price);
		}
		return res;
	}
}

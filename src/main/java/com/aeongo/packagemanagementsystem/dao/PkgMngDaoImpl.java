package com.aeongo.packagemanagementsystem.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aeongo.packagemanagementsystem.entity.OrderServiceUsage;
import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;
import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.entity.ServicePrivilege;
import com.aeongo.packagemanagementsystem.repo.OrderServiceUsageRepository;
import com.aeongo.packagemanagementsystem.repo.PackageInfoRepository;
import com.aeongo.packagemanagementsystem.repo.PlanRepository;
import com.aeongo.packagemanagementsystem.repo.PlanUsageRepository;
import com.aeongo.packagemanagementsystem.repo.ServicePrivilegeRepository;
import com.aeongo.packagemanagementsystem.repo.ServiceRepository;
@Repository
public class PkgMngDaoImpl implements PkgMngDao{
	@Autowired 
	PackageInfoRepository packageInfoRepository;
	@Autowired
	PlanUsageRepository planUsageRepository;
	@Autowired
	PlanRepository planRepository;
	@Autowired
	OrderServiceUsageRepository orderServiceUsageRepository;
	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	ServicePrivilegeRepository servicePrivilegeRepository;
	
	
	@Override
	public List<PackageInfo> getPackageInfo(Integer packageId,Integer doctorId) {
		return packageInfoRepository.findByPackageIdAndDoctorIdIgnoreCase(packageId,doctorId);
		//return packageInfoRepository.findAll();
	}
	
	@Override
	public List<Plan> getPlansByPackageId(Integer packageId){
		return planRepository.findAllByPackageId(packageId);
	}
	@Override
	public List<PlanUsage> getPurchasedPlans(Integer doctorId,Integer patientId,List<Integer> plans){
		return planUsageRepository.findAllValidByPatientIdAndDoctorIdAndPlanIdIn(doctorId,patientId,plans);//add expire check.
	}
	@Override
	public void saveServiceUsage(Integer patientId, Integer doctorId, Integer planId, Integer serviceId, Timestamp time) {
		OrderServiceUsage newOne = new OrderServiceUsage();
		newOne.setData(patientId,doctorId,planId,serviceId,time);
		orderServiceUsageRepository.save(newOne);
	}
	
	@Override
	public PlanUsage getPlanUsage(Integer patientId, Integer doctorId, Integer planId,Integer serviceId) {
		return planUsageRepository.getSubscribByPatientIdAndDoctorIdAndPlanIdAndServiceId(patientId,doctorId,planId,serviceId);
	}

	@Override
	public void savePlanUsage(PlanUsage record) {
		planUsageRepository.save(record);
		
	}

	@Override
	public List<Service> findAllServicesById(List<Integer> serviceIds) {
		return (List<Service>) serviceRepository.findAllById(serviceIds);
	}

	@Override
	public List<ServicePrivilege> findPrivilegesByServiceId(Integer serviceId) {
		return servicePrivilegeRepository.findByServiceId(serviceId);
	}
}

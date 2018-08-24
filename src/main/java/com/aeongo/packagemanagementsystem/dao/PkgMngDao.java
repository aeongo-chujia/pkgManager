package com.aeongo.packagemanagementsystem.dao;

import java.sql.Timestamp;
import java.util.List;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;
import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.entity.ServicePrivilege;
import com.aeongo.packagemanagementsystem.repo.ServicePrivilegeRepository;

public interface PkgMngDao {
	public List<PackageInfo> getPackageInfo(Integer packageId,Integer doctorId);
	
	public List<Plan> getPlansByPackageId(Integer packageId);
	
	public List<PlanUsage> getPurchasedPlans(Integer doctorId,Integer patientId,List<Integer> plans);
	
	public void saveServiceUsage(Integer patientId, Integer doctorId, Integer planId, Integer serviceId, Timestamp time);
	
	public PlanUsage getPlanUsage(Integer patientId, Integer doctorId, Integer planId,Integer serviceId);

	public void savePlanUsage(PlanUsage record);
	
	public List<Service> findAllServicesById(List<Integer> serviceIds);
	
	public List<ServicePrivilege> findPrivilegesByServiceId(Integer serviceId);
}

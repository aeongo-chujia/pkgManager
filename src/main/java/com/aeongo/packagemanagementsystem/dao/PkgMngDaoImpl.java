package com.aeongo.packagemanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;
import com.aeongo.packagemanagementsystem.repo.PackageInfoRepository;
import com.aeongo.packagemanagementsystem.repo.PlanRepository;
import com.aeongo.packagemanagementsystem.repo.PlanUsageRepository;

public class PkgMngDaoImpl implements PkgMngDao{
	@Autowired 
	PackageInfoRepository packageInfoRepository;
	@Autowired
	PlanUsageRepository planUsageRepository;
	@Autowired
	PlanRepository planRepository;
	
	@Override
	public List<PackageInfo> getPackageInfo(Integer packageId,Integer doctorId) {
		return packageInfoRepository.findAllByPackageIdAndDoctorId(packageId,doctorId);
	}
	
	@Override
	public List<Integer> getPlanIdsByPackageId(Integer packageId){
		return planRepository.findAllPlanIdByPackageId(packageId);
	}
	
	@Override
	public List<PlanUsage> getPurchasedPlans(Integer doctorId,Integer patientId,List<Integer> plans){
		return planUsageRepository.findAllByPatientIdAndDoctorIdAndPlanIdIn(doctorId,patientId,plans);
	}
	
}

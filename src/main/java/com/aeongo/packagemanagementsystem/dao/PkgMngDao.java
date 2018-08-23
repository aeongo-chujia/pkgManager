package com.aeongo.packagemanagementsystem.dao;

import java.util.List;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.Plan;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;

public interface PkgMngDao {
	public List<PackageInfo> getPackageInfo(Integer packageId,Integer doctorId);
	
	public List<Integer> getPlanIdsByPackageId(Integer packageId);
	
	public List<PlanUsage> getPurchasedPlans(Integer doctorId,Integer patientId,List<Integer> plans);
}

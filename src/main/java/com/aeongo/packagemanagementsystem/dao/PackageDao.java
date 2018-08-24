package com.aeongo.packagemanagementsystem.dao;

import java.util.List;

import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;

public interface PackageDao {

	com.aeongo.packagemanagementsystem.entity.Package findById(Integer packageId);
	
	List<com.aeongo.packagemanagementsystem.entity.Package> findAllById(List<Integer> packageIds);


}

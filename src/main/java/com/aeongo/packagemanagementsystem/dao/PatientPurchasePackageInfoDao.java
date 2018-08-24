package com.aeongo.packagemanagementsystem.dao;

import java.util.List;

import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;

public interface PatientPurchasePackageInfoDao {

	public List<PatientPurchasePackageInfo> findByPatient(Integer patientId);
	
	public List<PatientPurchasePackageInfo> findByFree();
}

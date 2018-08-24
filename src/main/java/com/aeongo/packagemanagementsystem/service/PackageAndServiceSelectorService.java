package com.aeongo.packagemanagementsystem.service;

import java.sql.Timestamp;
import java.util.List;

import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;

public interface PackageAndServiceSelectorService {
	
	
	public ServiceSelectorResponse mentalHealthServiceSelectorService(Integer patientId);
	
	public PackageSelectorResponse packageSelectorService(Integer patientId,Integer doctorId);
	
	public PackageResponse packageDetailInfo(Integer packageId, Integer patientId, Integer doctorId);
	
	public int UpdateServiceUsage(Integer patientId, Integer doctorId, Integer planId, Integer serviceId);
	
	public ServiceSelectorResponse physicalHealthSelectorService(Integer patientId);
}

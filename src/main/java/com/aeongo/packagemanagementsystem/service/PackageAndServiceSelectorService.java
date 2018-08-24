package com.aeongo.packagemanagementsystem.service;

import java.util.List;

import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;

public interface PackageAndServiceSelectorService {
	
	
	public ServiceSelectorResponse mentalHealthServiceSelectorService(Integer patientId);
	
	public PackageSelectorResponse packageSelectorService(Integer patientId,String access_token);
	

}

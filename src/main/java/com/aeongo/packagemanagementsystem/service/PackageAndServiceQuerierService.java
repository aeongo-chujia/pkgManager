package com.aeongo.packagemanagementsystem.service;

import java.util.List;

import com.aeongo.packagemanagementsystem.response.PackageResponse;

public interface PackageAndServiceQuerierService {
	
	public List<PackageResponse> getPackageByDoctor(Integer patientId, Integer doctorId, String access_token);
}

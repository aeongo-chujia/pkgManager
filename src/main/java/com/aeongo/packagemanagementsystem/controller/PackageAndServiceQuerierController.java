package com.aeongo.packagemanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageResponse;

import io.swagger.annotations.ApiOperation;


@Controller
public class PackageAndServiceQuerierController {

	
	/** 
	* @Title: Service Querier
	* @Description: Return the services based on the serviceType to the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Query Services",
			tags = {"Package And Service Querier"})
	@PostMapping("/getServices")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<List<Service>> getServices(
			@RequestParam(name = "serviceType", required = true) String serviceType,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
	
	/** 
	* @Title: Service Querier
	* @Description: Return the services based on the serviceType to the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Query A Service Based On the",
			tags = {"Package And Service Querier"})
	@PostMapping("/getService")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<Service> getService(
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
	
	/** 
	* @Title: Package Querier
	* @Description: Return the packages based on doctor
	* @author Sun
	*/
	@ApiOperation(value = "Query Packages Based On The Doctor",
			tags = {"Package And Service Querier"})
	@PostMapping("/getPackageByDoctor")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<List<PackageResponse>> getPackageByDoctor(
			@RequestParam(name = "doctorId", required = true) Integer doctorId,
			@RequestParam(name = "includeSystemPackage", required = true) Boolean includeSystemPackage,
			@RequestParam(name = "offeredByDoctorOnly", required = true) Boolean offeredByDoctorOnly,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
	
	/** 
	* @Title: Package Querier
	* @Description: Return the packages based on the service
	* @author Sun
	*/
	@ApiOperation(value = "Query Packages Based On The Service",
			tags = {"Package And Service Querier"})
	@PostMapping("/getPackageByService")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<List<PackageResponse>> getPackageByService(
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
}

package com.aeongo.packagemanagementsystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PackageAndServiceSelectorController {

	
	
	private PackageAndServiceSelectorService serviceAndPackageSelectorService;
	
	@Autowired
	public PackageAndServiceSelectorController(PackageAndServiceSelectorService serviceAndPackageSelectorService) {
		this.serviceAndPackageSelectorService = serviceAndPackageSelectorService;
	}


	
	/** 
	* @Title: Physical Health Service Selector
	* @Description: Select physical health service based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select physical health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/physicalHealthServiceSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> physicalHealthServiceSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		
		//hard-coded dummy data for presentation
		//services.add(new Service(1, "service1", "1", "paid", new Date(), "service for baby under 1", "/data/image/service1.jpg"));
		return null;
	}
	
	
	
	/** 
	* @Title: Mental Health Service Selector
	* @Description: Select mental health services based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select mental health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/mentalHealthServiceSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> mentalHealthServiceSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		return null;
	}
	
	
	
	
	/** 
	* @Title: Health History Selector
	* @Description: Select health history services based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select mental health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/healthHistorySelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> healthHistorySelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		//return serviceAndPackageSelectorService.mentalHealthServiceSelectorService(patientId);
		return null;
	}
	
	
	
	
	
	/** 
	* @Title: Package Selector
	* @Description: Select packages based on patientId and doctorId
	* @author Sun
	*/
	@ApiOperation(value = "Select package",
			tags = {"Package And Service Selector"})
	@PostMapping("/packageSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<PackageSelectorResponse> packageSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "doctorId",required=false) Integer doctorId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		return null;
	}
	
}

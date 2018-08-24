package com.aeongo.packagemanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.OrderResponse;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackagePurchaseService;
import com.aeongo.packagemanagementsystem.service.ValidationService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PackagePurchaseController {

	
	private PackagePurchaseService packagePurchaseService;
	
	private EmrInformationService emrInformationService;
	
	private ValidationService verificationService;
	
	
	@Autowired
	public PackagePurchaseController(PackagePurchaseService packagePurchaseService,
			EmrInformationService emrInformationService, ValidationService verificationService) {
		this.packagePurchaseService = packagePurchaseService;
		this.emrInformationService = emrInformationService;
		this.verificationService = verificationService;
	}
	
	
	/** 
	* @Title: Package Purchase Api
	* @Description: Gather package purchase report from the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Order patient purchase",
			tags = {"Package Purchase"})
	@PostMapping("/packagePurchase")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<OrderResponse> packagePurchase(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "packageId", required = true) Integer packageId,
			@RequestParam(name = "planId", required = true) Integer planId,
			@RequestParam(name = "doctorId", required = false) Integer doctorId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		

		
		//the response will be returned
		GeneralResponse<OrderResponse> response = new GeneralResponse<OrderResponse>();
		
		
		response.setMsg("purchase success");
		response.setStatus(0);
		response.setData(new OrderResponse(1537284952));
		
		response.setData(packagePurchaseService.packagePurchase(patientId, packageId, planId, doctorId));
		
		return response;
	}
}

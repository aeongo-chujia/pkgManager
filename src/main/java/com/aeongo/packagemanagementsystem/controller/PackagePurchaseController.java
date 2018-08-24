package com.aeongo.packagemanagementsystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.OrderResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class PackagePurchaseController {

	
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
		GeneralResponse<OrderResponse> response = new GeneralResponse<OrderResponse>();
		response.setData(new OrderResponse(111));
		return response;
	}
}

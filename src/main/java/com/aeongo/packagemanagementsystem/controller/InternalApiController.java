package com.aeongo.packagemanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.GetServiceCountResponse;

import io.swagger.annotations.ApiOperation;


@RestController
public class InternalApiController {	
	
	/** 
	* @Title: Package Usage Report
	* @Description: Gather package usage report from the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Report package usage information",
			tags = {"Internal Api"})
	@PostMapping("/packageUsage")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse packageUsage(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "packageId", required = true) Integer packageId,
			@RequestParam(name = "planId", required = true) Integer planId,
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "doctorId", required = false) Integer doctorId,
			@RequestParam(name = "serviceCount", required = true) Integer serviceCount,
			@RequestParam(name = "access_token", required = true) String access_token){
		GeneralResponse response = new GeneralResponse<>();
		response.setMsg("report success");
		response.setStatus(0);
		return response;
	}
	
	
	
	/** 
	* @Title: Get Service Usage Count
	* @Description: Get Service Usage Count
	* @author Sun
	*/
	@ApiOperation(value = "Get Service Usage Count",
			tags = {"Internal Api"})
	@PostMapping("/getServiceCount")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<GetServiceCountResponse> getServiceCount(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "packageId", required = true) Integer packageId,
			@RequestParam(name = "planId", required = true) Integer planId,
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "doctorId", required = false) Integer doctorId,
			@RequestParam(name = "access_token", required = true) String access_token){
		GeneralResponse<GetServiceCountResponse> response = new GeneralResponse<>();
		response.setMsg("retrieve success");
		response.setStatus(0);
		response.setData(new GetServiceCountResponse(50));
		return response;
	}
	
	
	
	/** 
	* @Title: Payment Callback
	* @Description: Payment Callback
	* @author Sun
	*/
	@ApiOperation(value = "Payment Callback",
			tags = {"Internal Api"})
	@PostMapping("/paymentCallback")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse paymentCallback(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "orderId", required = true) Integer orderId,
			@RequestParam(name = "paymentStatus", required = true) String paymentStatus,
			@RequestParam(name = "access_token", required = true) String access_token){
		GeneralResponse response = new GeneralResponse<>();
		response.setMsg("callback success");
		response.setStatus(0);
		return response;
	}

}

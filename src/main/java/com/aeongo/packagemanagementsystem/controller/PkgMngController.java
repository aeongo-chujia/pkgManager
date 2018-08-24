package com.aeongo.packagemanagementsystem.controller;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/pkg")
public class PkgMngController {
	@Autowired
	PackageAndServiceSelectorService packageService;
	@ApiOperation(value = "Process the Event", notes = "Input of type Event required", response = GeneralResponse.class)
	@ApiResponses({ @ApiResponse(code = 201, response = GeneralResponse.class, message = "Done") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getPlanByPackage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResponse<PackageResponse> getPackageInfo(			
			@RequestParam(value = "packageId", required = true) Integer packageId,
			@RequestParam(value = "patientId", required = true) Integer patientId,
			@RequestParam (value = "doctorId", required =true) Integer doctorId) throws JsonProcessingException {

		PackageResponse res = packageService.packageDetailInfo(packageId, patientId, doctorId);
		// EPResponse res = instService.Process(event);// new
		// EPResponse(0,jsonMember,"empty");
		return new GeneralResponse<PackageResponse>(200,"success",res);
	}
	@ApiOperation(value = "Process the Event", notes = "Input of type Event required", response = GeneralResponse.class)
	@ApiResponses({ @ApiResponse(code = 201, response = GeneralResponse.class, message = "Done") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/PackageUsage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResponse<Integer> PackageUsage(			
			@RequestParam(value = "planId", required = true) Integer planId,
			@RequestParam (value = "serviceId", required =true) Integer serviceId,
			@RequestParam(value = "patientId", required = true) Integer patientId,
			@RequestParam (value = "doctorId", required =true) Integer doctorId
			) throws JsonProcessingException {
		packageService.UpdateServiceUsage(patientId, doctorId, planId, serviceId);
		//PackageResponse res = packageService.packageDetailInfo(packageId, patientId, doctorId);
		// EPResponse res = instService.Process(event);// new
		// EPResponse(0,jsonMember,"empty");
		return new GeneralResponse<Integer>(200,"success",1);
	}
	@ApiOperation(value = "Process the Event", notes = "Input of type Event required", response = GeneralResponse.class)
	@ApiResponses({ @ApiResponse(code = 201, response = GeneralResponse.class, message = "Done") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/physicalHealthServiceSelector", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResponse<ServiceSelectorResponse> physicalHealthServiceSelector(		
			@RequestParam(value = "patientId", required = true) Integer patientId,
			@RequestParam (value = "access_token", required =true) String access_token
			) throws JsonProcessingException {
		
		//PackageResponse res = packageService.packageDetailInfo(packageId, patientId, doctorId);
		// EPResponse res = instService.Process(event);// new
		// EPResponse(0,jsonMember,"empty");
		ServiceSelectorResponse res = packageService.physicalHealthSelectorService(patientId);
		return new GeneralResponse<ServiceSelectorResponse>(200,"success",res);
	}
	@ApiOperation(value = "Process the Event", notes = "Input of type Event required", response = GeneralResponse.class)
	@ApiResponses({ @ApiResponse(code = 201, response = GeneralResponse.class, message = "Done") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/healthHistorySelectorr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralResponse<ServiceSelectorResponse> healthHistorySelector(		
			@RequestParam(value = "patientId", required = true) Integer patientId,
			@RequestParam (value = "access_token", required =true) String access_token
			) throws JsonProcessingException {
		
		//PackageResponse res = packageService.packageDetailInfo(packageId, patientId, doctorId);
		// EPResponse res = instService.Process(event);// new
		// EPResponse(0,jsonMember,"empty");
		ServiceSelectorResponse res = packageService.physicalHealthSelectorService(patientId);
		return new GeneralResponse<ServiceSelectorResponse>(200,"success",res);
	}
}

package com.aeongo.packagemanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.response.OrderResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackagePurchaseService;

@Service
public class PackagePurchaseServiceImpl implements PackagePurchaseService{

	private EmrInformationService emrInformationService;
	
	@Autowired
	public PackagePurchaseServiceImpl(EmrInformationService emrInformationService) {
		this.emrInformationService = emrInformationService;
	}
	
	@Override
	public OrderResponse packagePurchase(Integer patientId, Integer packageId, Integer planId, Integer doctorId) {

		//1.Validate the information
		//1.1.validate patient and access_token
		//1.2.validate the package and plan's existing
		//1.3.validate the doctor's existing
		
		//2.Calculate the plan's total price
		
		
		//3.Initiate an order in Chiese order api
		
		
		//4.Add a new order in db and set its status to 'created'
		
		
		//5.Response the orderId back
		
		
		return null;
	}

	
}

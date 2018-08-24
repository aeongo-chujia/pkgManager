package com.aeongo.packagemanagementsystem.service;

import com.aeongo.packagemanagementsystem.response.OrderResponse;

public interface PackagePurchaseService {
	
	public OrderResponse packagePurchase(Integer patientId,Integer packageId,Integer planId,Integer doctorId);

}

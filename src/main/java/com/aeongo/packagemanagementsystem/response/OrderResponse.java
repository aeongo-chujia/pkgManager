package com.aeongo.packagemanagementsystem.response;

import lombok.Data;

@Data
public class OrderResponse {

	private final Integer orderId;
	
	public OrderResponse(Integer orderId) {
		this.orderId = orderId;
	}
}

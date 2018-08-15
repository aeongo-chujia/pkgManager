package com.aeongo.packagemanagementsystem.response;

import lombok.Data;

@Data
public class GetServiceCountResponse {

	private final Integer serviceCount;
	
	public GetServiceCountResponse(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}
}

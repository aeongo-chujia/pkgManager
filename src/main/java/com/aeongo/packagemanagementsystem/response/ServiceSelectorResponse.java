package com.aeongo.packagemanagementsystem.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ServiceSelectorResponse {
	
	
	private final List<Service> services;
	private final Date expirationDate;
	
	
	public ServiceSelectorResponse(List<Service> services, Date expirationDate) {
		super();
		this.services = services;
		this.expirationDate = expirationDate;
	}
	
	@Data
	private static class Service{
		private Integer serviceId;
		private String title;
		private String description;
		private String subtitle;
		private String shortDescription;
		private String picture;
		private String footnote;
		private String action;
		private String actionIcon;
		private String statusIcon;
		private String bgColor;
		private String fgColor;
		private String tileSize;
		private String serviceType;
		private String serviceDisplayPriority;
		private String purchaseStatus;
		private Date serviceExpirationDate;
		private Integer serviceCount;
	}

}

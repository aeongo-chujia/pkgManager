package com.aeongo.packagemanagementsystem.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ServiceResponse {

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
	private String style;
	private String serviceType;
	private String serviceDisplayPriority;
	private String purchaseStatus;
	private Date serviceExpirationDate;
	private Integer serviceCount;
	
	
	public ServiceResponse(Integer serviceId, String title, String description, String subtitle,
			String shortDescription, String picture, String footnote, String action, String actionIcon,
			String statusIcon, String style, String serviceType, String serviceDisplayPriority, String purchaseStatus,
			Date serviceExpirationDate, Integer serviceCount) {
		super();
		this.serviceId = serviceId;
		this.title = title;
		this.description = description;
		this.subtitle = subtitle;
		this.shortDescription = shortDescription;
		this.picture = picture;
		this.footnote = footnote;
		this.action = action;
		this.actionIcon = actionIcon;
		this.statusIcon = statusIcon;
		this.style = style;
		this.serviceType = serviceType;
		this.serviceDisplayPriority = serviceDisplayPriority;
		this.purchaseStatus = purchaseStatus;
		this.serviceExpirationDate = serviceExpirationDate;
		this.serviceCount = serviceCount;
	}
	
	
}

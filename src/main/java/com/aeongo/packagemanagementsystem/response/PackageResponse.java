package com.aeongo.packagemanagementsystem.response;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class PackageResponse {
	
	private String packageId;
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
	private String packageDisplayPriority;
	private String purchaseStatus;
	private String purchasedPlanType;
	private Boolean purchasedPlanUpgradeable;
	private Integer planIdThatIsUpgradeableTo;
	private Date purchasedPlanSubscriptionExpirationDate;
	private Integer purchasedPlanUsageCountRemaining;

}

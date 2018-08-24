package com.aeongo.packagemanagementsystem.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Data
public class PackageSelectorResponse {
	
	private List<Package> packages;
	
	public PackageSelectorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	@Data
	public static class Package{
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
		private String style;
		private String packageDisplayPriority;
		private String purchaseStatus;
		private String purchasedPlanType;
		private Boolean purchasedPlanUpgradeable;
		private Integer planIdThatIsUpgradeableTo;
		private Date purchasedPlanSubscriptionExpirationDate;
		private Integer purchasedPlanUsageCountRemaining;
	}
	
}

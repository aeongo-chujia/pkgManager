package com.aeongo.packagemanagementsystem.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.json.JSONArray;

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
	private JSONArray purchasedPlans;
	private List<Plan> plans;
	
	@Data
	private static class Plan{
		private Integer planId;
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
		private String planType;
		private BigDecimal price;
		private String planDisplayPriority;
		private Date planSubscriptionExpirationDate;
		private Integer usageCount;
		private Integer usageCountRemaining;
		private String purchaseStatus;
		private String activeStatus;
	}
}

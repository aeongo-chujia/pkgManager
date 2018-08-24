package com.aeongo.packagemanagementsystem.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.json.JSONArray;

import lombok.AllArgsConstructor;
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
		private List<CurPlan> currentPlans = new ArrayList<>();
		private List<UnPlan> plans = new ArrayList<>();
		
		public void addCurrentPlan(Integer planId,String current, Timestamp expiration, String remaining, String picture) {
			CurPlan newOne = new CurPlan(planId,current,expiration,remaining,picture);
			currentPlans.add(newOne);
		}
		
		public void addPlan(Integer planId,String title, String description, String subtitle, String shortDescription, String picture,String footnote,String action,BigDecimal price) {
			UnPlan newOne = new UnPlan(planId, title, description, subtitle, shortDescription, picture, footnote, action,price);
			plans.add(newOne);
		}
	@Data
	@AllArgsConstructor
	private static class CurPlan{
		private Integer planId;
		private String current;
		private Timestamp expiration;
		private String remaining;
		private String picture;
	}

	@Data
	@AllArgsConstructor
	private static class UnPlan{
		private Integer planId;
		private String title;
		private String description;
		private String subtitle;
		private String shortDescription;
		private String picture;
		private String footnote;
		private String action;
//		private String actionIcon;
//		private String statusIcon;
//		private String bgColor;
//		private String fgColor;
//		private String tileSize;
//		private String planType;
		private BigDecimal price;
//		private String planDisplayPriority;
//		private Date planSubscriptionExpirationDate;
//		private Integer usageCount;
//		private Integer usageCountRemaining;
//		private String purchaseStatus;
//		private String activeStatus;
	}
}

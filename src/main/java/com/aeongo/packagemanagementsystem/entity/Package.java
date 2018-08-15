package com.aeongo.packagemanagementsystem.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@Data
@Entity
@Table(name="package")
public class Package {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="package_id")
	private Integer packageId;
	
	@Column(name="package_name",nullable = false)
	private String packageName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="package_display_priority")
	private String packageDisplayPriority;
	
	@Column(name="purchase_status")
	private String purchaseStatus;
	
	@Column(name="purchased_plan_type")
	private String purchasedPlanType;
	
	@Column(name="purchased_plan_upgradeable")
	private Boolean purchasedPlanUpgradeable;
	
	@Column(name="plan_id_that_is_upgradeable_to")
	private Integer planIdThatIsUpgradeableTo;
	
	@Column(name="purchased_plan_subscription_expiration_date")
	private Date purchasedPlanSubscriptionExpirationDate;
	
	@Column(name="purchased_plan_usage_count_remaining")
	private Integer purchasedPlanUsageCountRemaining;

	
	public Package() {
		
	}
	
}

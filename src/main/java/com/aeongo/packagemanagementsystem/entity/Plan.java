package com.aeongo.packagemanagementsystem.entity;

import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;


@Data
@Entity
@Table(name="plan")
public class Plan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="plan_id")
	private Integer planId;
	
	@Column(name="plan_name",nullable = false)
	private String plan_Name;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="plan_display_priority")
	private String planDisplayPriority;
	
	@Column(name="plan_subscription_expiration_date")
	private Date planSubscriptionExpirationDate;
	
	@Column(name="usage_count")
	private Integer usageCount;
	
	@Column(name="usage_count_remaining")
	private Integer usageCountRemaining;
	
	@Column(name="purchase_status")
	private String purchaseStatus;
	
	@Column(name="active_status")
	private String activeStatus;
	
	
	public Plan() {
		
	}
}

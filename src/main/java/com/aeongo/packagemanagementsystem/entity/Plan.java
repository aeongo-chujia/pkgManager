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
	
	@Column(name="duration")
	private Integer duration;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="plan_picture")
	private String planPicture;
	
	@Column(name="plan_display_priority")
	private String planDisplayPriority;
	
	@Column(name="active_status")
	private String activeStatus;
	
	@Column(name="plan_upgradeable")
	private Boolean planUpgradeable;
	
	@Column(name="plan_id_that_is_upgradeable_to")
	private Integer planIdThatIsUpgradeableTo;
	
	@Column(name="package_id")
	private Integer packageId;
	
	public Plan() {
		
	}
}

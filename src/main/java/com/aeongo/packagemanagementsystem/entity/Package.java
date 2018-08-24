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

//Last Updated by Chujia on 08/21/2018
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
	
	@Column(name="package_type")
	private String packageType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="age_range")
	private String ageRange;
//	@Column(name="package_display_priority")
//	private String packageDisplayPriority;
	
	@Column(name="age_range")
	private String ageRange;
	
	public Package() {
		
	}
	
}

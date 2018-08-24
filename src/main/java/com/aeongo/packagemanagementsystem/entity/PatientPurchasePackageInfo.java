package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="patient_purchase_package_info")
public class PatientPurchasePackageInfo {

	@Column
	@Id
	private Integer orderId;
	
	@Column
	private Integer doctorId;
	
	@Column
	private Integer patientId;
	
	@Column
	private Integer planId;
	
	@Column
	private BigDecimal totalPrice;
	
	@Column
	private Integer packageId;
	
	@Column
	private String description;
	
	@Column
	private String packageDisplayPriority;
	
	@Column
	private String packageName;
	
	@Column
	private String packageType;
	
	@Column
	private String picture;
	
	@Column
	private String shortDescription;
	
	@Column
	private String ageRange;

}

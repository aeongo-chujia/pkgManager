package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.json.JSONObject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "package_info_latest")
@IdClass(PackageInfoPK.class)
public class PackageInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "package_id")
	private Integer packageId;
	
	@Column(name = "pkg_description")
	private String pkgDescription;
	
	@Column(name = "pkg_name")
	private String pkgName;
	
	@Column(name = "pkg_picture")
	private String pkgPicture;
	
	@Column(name = "pkg_shotdesc")
	private String pkgShotdesc;
	
	@Id
	@Column(name = "plan_id")
	private Integer planId;
	
	@Column(name = "duration")
	private String duration;
	@Column(name = "plan_display_priority")
	private String planDisplayPriority;
	
	@Column(name = "plan_type")
	private String planType;
	@Column(name = "base_price")
	private Number basePrice;
	@Column(name = "plan_shotdesc")
	private String planShotdesc;
	
	@Id
	@Column(name = "service_id")
	private Integer serviceId;
	
	@Column(name = "service_description")
	private String serviceDescription;
	@Column(name = "service_picture")
	private String servicePicture;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "service_type")
	private String serviceType;
	@Column(name = "service_shotdesc")
	private String serviceShotdesc;
	@Column(name = "unit_price")
	private String unitPrice;
	
	@Id
	@Column(name = "doctor_id")
	private Integer doctorId = 0;
	@Column(name = "quantity")
	private Integer quantity;
}

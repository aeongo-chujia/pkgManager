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
@Table(name="package_plan_service_quantity")
@IdClass(PackagePlanServiceQuantity.PK.class)
public class PackagePlanServiceQuantity {

	
	@Id
	@Column(name="package_id")
	private Integer packageId;
	
	@Id
	@Column(name="plan_id")
	private Integer planId;
	
	@Id
	@Column(name="service_id")
	private Integer serviceId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	
	public static class PK implements Serializable {
		protected Integer packageId;
		protected Integer planId;
		protected Integer serviceId;
		
		protected PK() {}
		
		public PK(Integer packageId, Integer planId,Integer serviceId) {
			super();
			this.packageId = packageId;
			this.planId = planId;
			this.serviceId = serviceId;
		}
	}
	
	
}

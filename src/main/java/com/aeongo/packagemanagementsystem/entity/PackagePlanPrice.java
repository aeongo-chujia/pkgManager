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
@Table(name="package_plan_price")
@IdClass(PackagePlanPrice.PK.class)
public class PackagePlanPrice {
	
	@Id
	@Column(name="package_id")
	private Integer packageId;
	
	@Id
	@Column(name="plan_id")
	private Integer planId;
	
	@Column(name="base_price")
	private BigDecimal basePrice;
	
	
	public static class PK implements Serializable {
		protected Integer packageId;
		protected Integer planId;
		
		protected PK() {}
		
		public PK(Integer packageId, Integer planId) {
			super();
			this.packageId = packageId;
			this.planId = planId;
		}
	}
	
}

package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="package_specialty")
@IdClass(PackageSpecialty.PK.class)
public class PackageSpecialty {
	
	@Id
	@Column(name="package_id")
	private Integer packageId;
	
	@Id
	@Column(name="specialty_id")
	private Integer specialtyId;
	
	
	public static class PK implements Serializable {
		protected Integer packageId;
		protected Integer specialtyId;
		
		protected PK() {}
		
		public PK(Integer packageId, Integer specialtyId) {
			super();
			this.packageId = packageId;
			this.specialtyId = specialtyId;
		}
	}

}

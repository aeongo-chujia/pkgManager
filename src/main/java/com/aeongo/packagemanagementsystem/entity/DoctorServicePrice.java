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
@Table(name="doctor_service_price")
@IdClass(DoctorServicePrice.PK.class)
public class DoctorServicePrice {


	@Id
	@Column(name="doctor_id")
	private Integer doctorId;
	
	@Id
	@Column(name="service_id")
	private Integer serviceId;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	
	public static class PK implements Serializable {
		protected Integer doctorId;
		protected Integer serviceId;
		
		protected PK() {}
		
		public PK(Integer doctorId, Integer serviceId) {
			super();
			this.doctorId = doctorId;
			this.serviceId = serviceId;
		}
	}
	
}

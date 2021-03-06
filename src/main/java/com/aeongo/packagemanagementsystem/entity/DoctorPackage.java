package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctor_package")
@IdClass(DoctorPackage.PK.class)
public class DoctorPackage {
	
	
	@Id
	@Column(name="doctor_id")
	private Integer doctorId;
	
	@Id
	@Column(name="package_id")
	private Integer packageId;
	
	@Column(name="begin_date")
	private Date beginDate;
	
	
	public static class PK implements Serializable {
		protected Integer doctorId;
		protected Integer packageId;
		
		protected PK() {}
		
		public PK(Integer doctorId, Integer packageId) {
			super();
			this.doctorId = doctorId;
			this.packageId = packageId;
		}
	}
}

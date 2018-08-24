package com.aeongo.packagemanagementsystem.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_service_usage")
public class OrderServiceUsage {
	public void setData(Integer patientId, Integer doctorId, Integer planId, Integer serviceId,
			Timestamp time) {
		this.id = 0;
		this.serviceId = serviceId;
		this.patientIdd = patientId;
		this.doctorId = doctorId;
		this.planId = planId;
		this.usedDate = time;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
	Integer id = 0;
	
	@Column(name = "service_id")
	Integer serviceId;
	
	 
	@Column(name = "plan_id")
	Integer planId;
	 
	@Column(name = "patient_id")
	Integer patientIdd;
	 
	@Column(name = "doctor_id")
	Integer doctorId;
	
	@Column(name = "used_date")
	Timestamp usedDate;
}

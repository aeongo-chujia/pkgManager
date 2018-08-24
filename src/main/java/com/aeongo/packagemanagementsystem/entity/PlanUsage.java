package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscription")
@IdClass(PlanUsagePK.class)
public class PlanUsage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "service_id")
	private Integer serviceId;
	@Id
	@Column(name = "plan_id")
	private Integer planId;
	@Id
	@Column(name = "patient_id")
	private Integer patientId;
	@Id
	@Column(name = "doctor_id")
	private Integer doctorId=0;
	
	@Column(name = "service_used")
	private Integer serviceUsed;
	
	@Column(name = "service_limit")
	private Integer serviceLimist;
	
	@Column(name = "start_date")
	private Timestamp startDate;
	
	@Column(name = "end_date")
	private Timestamp endDate;

}

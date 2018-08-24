package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlanUsagePK implements Serializable{
	private static final long serialVersionUID = -11L;
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
}

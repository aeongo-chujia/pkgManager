package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


//Last Updated by Chujia on 08/21/2018
@Data
@Entity
@Table(name="order")
public class Order {

	
	@Id
	@Column(name="order_id")
	private Integer orderId;
	
	@NotNull
	@Column(name="patient_id")
	private Integer patientId;

	
	@NotNull
	@Column(name="plan_id")
	private Integer planId;
	
	@Column(name="doctor_id")
	private Integer doctorId;
	
	@Column(name="purchase_date")
	private Date purchaseDate;

	
	@Column(name="total_price")
	private Integer totalPrice;
	
	@Column(name="order_status")
	private Integer orderStatus;
	
	@Column(name="plan_start_date")
	private Timestamp planStartDate;
	
	@Column(name="plan_end_date")
	private Timestamp planEndDate;
}
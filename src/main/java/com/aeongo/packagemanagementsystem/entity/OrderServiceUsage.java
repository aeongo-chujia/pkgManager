package com.aeongo.packagemanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="order_service_usage")
@IdClass(OrderServiceUsage.PK.class)
public class OrderServiceUsage {

	@Id
	@Column(name="order_id")
	private Integer orderId;
	
	@Id
	@Column(name="service_id")
	private Integer serviceId;
	
	@Column(name="usage_count")
	private Integer usageCount;
	
	@Column(name="usage_count_remaining")
	private Integer usageCountRemaining;
	
	
	public static class PK implements Serializable {
		protected Integer orderId;
		protected Integer serviceId;
		
		protected PK() {}
		
		public PK(Integer orderId,Integer serviceId) {
			super();
			this.orderId = orderId;
			this.serviceId = serviceId;
		}
	}
	
	
}
package com.aeongo.packagemanagementsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="service")
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="service_id")
	private Integer serviceId;
	
	@Column(name="service_name",nullable = false)
	private String serviceName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="service_type")
	private String serviceType;

	@Column(name="service_display_priority")
	private String serviceDisplayPriority;
	
	
	public Service() {
		
	}	
	
	
}

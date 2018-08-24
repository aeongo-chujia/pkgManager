package com.aeongo.packagemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="service_privilege_relation")
public class ServicePrivilege {
	@Id
	@Column(name = "privilege_id")
	private Integer privilegeId;
	
	@Column(name = "privilege_name")
	private String privilegeName;
	
	@Column(name = "service_id")
	private Integer serviceId;
}

package com.aeongo.packagemanagementsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="specialty")
public class Specialty {

	
	@Id
	@Column(name="specialty_id")
	private Integer specialtyId;
	
	@NotNull
	@Column(name="specialty")
	private String specialty;
	
}

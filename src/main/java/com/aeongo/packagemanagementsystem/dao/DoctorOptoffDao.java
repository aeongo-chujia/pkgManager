package com.aeongo.packagemanagementsystem.dao;

import java.util.List;

import com.aeongo.packagemanagementsystem.entity.DoctorOptoff;

public interface DoctorOptoffDao {

	public List<DoctorOptoff> findAllByDoctorId(Integer doctorId);
}

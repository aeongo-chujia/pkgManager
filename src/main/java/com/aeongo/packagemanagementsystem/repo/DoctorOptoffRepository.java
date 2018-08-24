package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeongo.packagemanagementsystem.entity.DoctorOptoff;

public interface DoctorOptoffRepository extends JpaRepository<DoctorOptoff, Integer>{

	public List<DoctorOptoff> findAllByDoctorId(Integer doctorId);
}

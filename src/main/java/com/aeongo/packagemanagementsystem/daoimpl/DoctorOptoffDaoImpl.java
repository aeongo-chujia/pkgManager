package com.aeongo.packagemanagementsystem.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aeongo.packagemanagementsystem.dao.DoctorOptoffDao;
import com.aeongo.packagemanagementsystem.entity.DoctorOptoff;
import com.aeongo.packagemanagementsystem.repo.DoctorOptoffRepository;

@Repository
public class DoctorOptoffDaoImpl implements DoctorOptoffDao {

	
	private DoctorOptoffRepository doctorOptoffRepository;
	
	public DoctorOptoffDaoImpl(DoctorOptoffRepository doctorOptoffRepository) {
		this.doctorOptoffRepository = doctorOptoffRepository;
	}
	
	@Override
	public List<DoctorOptoff> findAllByDoctorId(Integer doctorId) {
		return doctorOptoffRepository.findAllByDoctorId(doctorId);
	}

}

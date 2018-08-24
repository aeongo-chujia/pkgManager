package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;

public interface PatientPurchasePackageInfoRepository extends JpaRepository<PatientPurchasePackageInfo, Integer>{

	public List<PatientPurchasePackageInfo> findAllByPatientId(Integer patientId);
	
	@Query(value = "select p from PatientPurchasePackageInfo p where p.totalPrice = '0.00' ")
	public List<PatientPurchasePackageInfo> findByFree();
}

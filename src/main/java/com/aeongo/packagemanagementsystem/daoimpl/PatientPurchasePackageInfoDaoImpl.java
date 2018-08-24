package com.aeongo.packagemanagementsystem.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aeongo.packagemanagementsystem.dao.PatientPurchasePackageInfoDao;
import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;
import com.aeongo.packagemanagementsystem.repo.PatientPurchasePackageInfoRepository;

@Repository
public class PatientPurchasePackageInfoDaoImpl implements PatientPurchasePackageInfoDao {
	
	private PatientPurchasePackageInfoRepository patientPurchasePackageInfoRepository;
	
	@Autowired
	public PatientPurchasePackageInfoDaoImpl(PatientPurchasePackageInfoRepository patientPurchasePackageInfoRepository) {
		this.patientPurchasePackageInfoRepository = patientPurchasePackageInfoRepository;
	}
	
	public List<PatientPurchasePackageInfo> findByPatient(Integer patientId){
		return patientPurchasePackageInfoRepository.findAllByPatientId(patientId);
	}

	@Override
	public List<PatientPurchasePackageInfo> findByFree() {
		return patientPurchasePackageInfoRepository.findByFree();
	}

}

package com.aeongo.packagemanagementsystem.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aeongo.packagemanagementsystem.dao.PackageDao;
import com.aeongo.packagemanagementsystem.entity.Package;
import com.aeongo.packagemanagementsystem.entity.PatientPurchasePackageInfo;
import com.aeongo.packagemanagementsystem.repo.PackageRepository;



@Repository
public class PackageDaoImpl implements PackageDao {
	
	private PackageRepository packageRepository;
	
	@Autowired
	public PackageDaoImpl(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}

	@Override
	public com.aeongo.packagemanagementsystem.entity.Package findById(Integer packageId) {
		return packageRepository.findById(packageId).get();
	}

	@Override
	public List<Package> findAllById(List<Integer> packageIds) {
		return packageRepository.findAllById(packageIds);
	}

}

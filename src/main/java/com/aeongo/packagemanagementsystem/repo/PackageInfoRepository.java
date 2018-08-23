package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;

public interface PackageInfoRepository extends CrudRepository<PackageInfo, Integer>{

	List<PackageInfo> findAllByPackageIdAndDoctorId(Integer packageId, Integer doctorId);

}

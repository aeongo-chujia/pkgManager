package com.aeongo.packagemanagementsystem.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;

public interface PackageInfoRepository extends PagingAndSortingRepository<PackageInfo, Integer>{
	@Query(value = "select p from PackageInfo p where p.packageId = :packageId  and p.doctorId = :doctorId")
	List<PackageInfo> findByPackageIdAndDoctorIdIgnoreCase(@Param("packageId") Integer packageId, @Param("doctorId") Integer doctorId);

	List<PackageInfo> findAll();

}

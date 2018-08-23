package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;

public interface PlanUsageRepository extends CrudRepository<PlanUsage, Integer>{

	List<PlanUsage> findAllByPatientIdAndDoctorIdAndPlanIdIn(Integer doctorId, Integer patientId, List<Integer> plans);

}

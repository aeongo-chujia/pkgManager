package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aeongo.packagemanagementsystem.entity.PackageInfo;
import com.aeongo.packagemanagementsystem.entity.PlanUsage;

public interface PlanUsageRepository extends CrudRepository<PlanUsage, Integer>{
	@Query(value = "select p from PlanUsage p where p.doctorId = :doctorId  and p. patientId = :patientId and p.planId in :plans")
	List<PlanUsage> findAllByPatientIdAndDoctorIdAndPlanIdIn(@Param("doctorId") Integer doctorId, @Param("patientId") Integer patientId,@Param("plans") List<Integer> plans);
	@Query(value = "select p from PlanUsage p where p.doctorId = :doctorId  and p. patientId = :patientId and p.planId in :plans and p.startDate<now() and p.endDate>now()")
	List<PlanUsage> findAllValidByPatientIdAndDoctorIdAndPlanIdIn(@Param("doctorId") Integer doctorId, @Param("patientId") Integer patientId,@Param("plans") List<Integer> plans);
	@Query(value = "select p from PlanUsage p where p.doctorId = :doctorId  and p. patientId = :patientId and p.planId = :planId and p.serviceId = :serviceId and p.startDate<now() and p.endDate>now()")
	PlanUsage getSubscribByPatientIdAndDoctorIdAndPlanIdAndServiceId(@Param("patientId") Integer patientId,@Param("doctorId") Integer doctorId,
			@Param("planId")Integer planId,@Param("serviceId") Integer serviceId);

}


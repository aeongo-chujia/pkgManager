package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aeongo.packagemanagementsystem.entity.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer>{

	List<Plan> findAllByPackageId(Integer packageId);

	List<Integer> findAllPlanIdByPackageId(Integer packageId);

}

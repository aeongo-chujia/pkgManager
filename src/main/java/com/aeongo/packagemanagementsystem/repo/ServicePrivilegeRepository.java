package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.entity.ServicePrivilege;


public interface ServicePrivilegeRepository extends CrudRepository<ServicePrivilege, Integer>{
	@Query(value = "select p from ServicePrivilege p where p.serviceId = :serviceId")
	List<ServicePrivilege> findByServiceId(@Param("serviceId")Integer serviceId);

	
	
}

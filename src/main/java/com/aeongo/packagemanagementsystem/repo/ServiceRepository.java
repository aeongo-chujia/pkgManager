package com.aeongo.packagemanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeongo.packagemanagementsystem.entity.Service;


public interface ServiceRepository extends PagingAndSortingRepository<Service, Integer>{

	
	
}

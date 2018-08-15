package com.aeongo.packagemanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aeongo.packagemanagementsystem.dao.ServiceDao;
import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.repo.ServiceRepository;


@Repository
public class ServiceDaoImpl implements ServiceDao {
	
	private ServiceRepository serviceRepository;
	
	@Autowired
	public ServiceDaoImpl(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@Override
	public Service findById(Integer serviceId) {
		return serviceRepository.findById(serviceId).get();
	}

}

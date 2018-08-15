package com.aeongo.packagemanagementsystem.dao;

import com.aeongo.packagemanagementsystem.entity.Service;

public interface ServiceDao {

	Service findById(Integer serviceId);

}

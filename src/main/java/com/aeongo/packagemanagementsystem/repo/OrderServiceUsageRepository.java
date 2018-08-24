package com.aeongo.packagemanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.aeongo.packagemanagementsystem.entity.OrderServiceUsage;
import com.aeongo.packagemanagementsystem.entity.PackageInfo;

public interface OrderServiceUsageRepository extends PagingAndSortingRepository<OrderServiceUsage, Integer>{

}

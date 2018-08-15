package com.aeongo.packagemanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.aeongo.packagemanagementsystem.entity.Package;

public interface PackageRepository extends CrudRepository<Package, Integer>{

}

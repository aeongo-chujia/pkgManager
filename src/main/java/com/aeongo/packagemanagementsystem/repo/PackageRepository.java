package com.aeongo.packagemanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.aeongo.packagemanagementsystem.entity.Package;

public interface PackageRepository extends JpaRepository<Package, Integer>{

}

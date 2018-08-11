package com.hackerrank.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.inventory.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor,Integer>{

}

package com.hackerrank.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.inventory.model.Inventory;


public interface InventoryRepository extends CrudRepository<Inventory,Integer> {

}

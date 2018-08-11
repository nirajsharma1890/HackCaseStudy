package com.hackerrank.inventory.repository;
import org.springframework.data.repository.CrudRepository;
import com.hackerrank.inventory.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}

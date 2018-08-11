package com.hackerrank.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.inventory.model.Customer;
import com.hackerrank.inventory.model.Inventory;
import com.hackerrank.inventory.model.Vendor;
import com.hackerrank.inventory.repository.CustomerRepository;
import com.hackerrank.inventory.repository.InventoryRepository;
import com.hackerrank.inventory.repository.VendorRepository;

@Service
public class InventoryService {
	
	@Autowired
	 private CustomerRepository customerRepository;
	@Autowired 
	 private VendorRepository vendorRepository;
	@Autowired
	 private InventoryRepository inventoryRepository;
	
	/*Begin of Customer Methods */
	public List<Customer> getAllCustomers(){
		List<Customer> customerList= new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}
	
	public Customer getCustomer(long id){
	    List<Customer> customerList= new ArrayList<Customer>();
	    Customer customer = null;
	    customerRepository.findAll().forEach(customerList::add);
		try {
			customer = customerList.stream().filter(c->c.getCustomerId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			customer=null;
		}
		return customer;
	}
	
	public Customer addCustomer(Customer customer){
		customerRepository.save(customer);
		return customer;
	}
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}
	/*End of Customer Methods */
	
	/*Begin of Vendor Methods */
	public List<Vendor> getAllVendors(){
		List<Vendor> vendorList= new ArrayList<Vendor>();
		vendorRepository.findAll().forEach(vendorList::add);
		return vendorList;
	}
	public Vendor getVendor(long id){
	    List<Vendor> vendorList= new ArrayList<Vendor>();
	    Vendor vendor = null;
	    vendorRepository.findAll().forEach(vendorList::add);
		try {
			vendor = vendorList.stream().filter(c->c.getVendorId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			vendor=null;
		}
		return vendor;
	}
	
	public Vendor addVendor(Vendor vendor){
		vendorRepository.save(vendor);
		return vendor;
	}
	public void deleteVendor(Vendor vendor) {
		vendorRepository.delete(vendor);
	}
	public void deleteAllVendors() {
		vendorRepository.deleteAll();
	}
	/*End of Vendor Methods */
	
	/*Begin of Inventory Methods */
	public List<Inventory> getAllInventories(){
		List<Inventory> inventoryList= new ArrayList<Inventory>();
		inventoryRepository.findAll().forEach(inventoryList::add);
		return inventoryList;
	}
	public Inventory getInventory(long id){
	    List<Inventory> inventoryList= new ArrayList<Inventory>();
	    Inventory inventory = null;
	    inventoryRepository.findAll().forEach(inventoryList::add);
		try {
			inventory = inventoryList.stream().filter(c->c.getSkuId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			inventory=null;
		}
		return inventory;
	}
	
	public Inventory addInventory(Inventory inventory){
		inventoryRepository.save(inventory);
		return inventory;
	}
	public void deleteInventory(Inventory inventory) {
		inventoryRepository.delete(inventory);
	}
	public void deleteAllInventory() {
		inventoryRepository.deleteAll();
	}
	/*End of Inventory Methods */
	
	
}
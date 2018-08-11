package com.hackerrank.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.inventory.model.Customer;
import com.hackerrank.inventory.model.Inventory;
import com.hackerrank.inventory.model.Vendor;
import com.hackerrank.inventory.service.InventoryService;
@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private InventoryService inventoryService;
	
	/*Begin of Customer Endpoints*/
	@GetMapping(value = "/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() throws Exception {
		List<Customer> customerList = this.inventoryService.getAllCustomers();
		if(customerList.size()==0)
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
		
    }
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id ) throws Exception {
		Customer customer = this.inventoryService.getCustomer(id);
		if(customer==null)
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = this.inventoryService.addCustomer(customer);
		if(createdCustomer!=null)
			return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);
		else
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id){
		Customer checkCustomer = this.inventoryService.getCustomer(id);
		if(checkCustomer!=null)
		{
			this.inventoryService.deleteCustomer(checkCustomer);
			return new ResponseEntity<Customer>(this.inventoryService.addCustomer(customer),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
		Customer checkCustomer = this.inventoryService.getCustomer(id);
	    if(checkCustomer!=null) {
	    	this.inventoryService.deleteCustomer(checkCustomer);
	    	return new ResponseEntity<Customer>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/customer/")
	public ResponseEntity<Customer> deleteAllCustomers() {
		if(this.inventoryService.getAllCustomers().size()!=0) {
			this.inventoryService.deleteAllCustomers();
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);		
	}
	/*End of Customer Endpoints*/
	
	/*Begin of Vendor Endpoints*/
	@GetMapping(value = "/vendor")
	public ResponseEntity<List<Vendor>> getAllVendors() throws Exception {
		List<Vendor> vendorList = this.inventoryService.getAllVendors();
		if(vendorList.size()==0)
			return new ResponseEntity<List<Vendor>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Vendor>>(vendorList,HttpStatus.OK);
		
    }
	
	@GetMapping(value = "/vendor/{id}")
	public ResponseEntity<Vendor> getVendor(@PathVariable("id") long id ) throws Exception {
		Vendor vendor = this.inventoryService.getVendor(id);
		if(vendor==null)
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
	}
	
	@PostMapping("/vendor")
	public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
		Vendor createdVendor = this.inventoryService.addVendor(vendor);
		if(createdVendor!=null)
			return new ResponseEntity<Vendor>(createdVendor,HttpStatus.CREATED);
		else
			return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/vendor/{id}")
	public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor, @PathVariable("id") long id){
		Vendor checkVendor = this.inventoryService.getVendor(id);
		if(checkVendor!=null)
		{
			this.inventoryService.deleteVendor(checkVendor);
			return new ResponseEntity<Vendor>(this.inventoryService.addVendor(vendor),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/vendor/{id}")
	public ResponseEntity<Vendor> deleteVendor(@PathVariable("id") long id) {
		Vendor checkVendor = this.inventoryService.getVendor(id);
	    if(checkVendor!=null) {
	    	this.inventoryService.deleteVendor(checkVendor);
	    	return new ResponseEntity<Vendor>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/vendor/")
	public ResponseEntity<Vendor> deleteAllVendors() {
		if(this.inventoryService.getAllVendors().size()!=0){
			this.inventoryService.deleteAllVendors();
			return new ResponseEntity<Vendor>(HttpStatus.OK);
		}else
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		
	}
	/*End of Vendor Endpoints*/
	
	/*Begin of Inventory Endpoints*/
	@GetMapping(value = "/item")
	public ResponseEntity<List<Inventory>> getAllInventories() throws Exception {
		List<Inventory> inventoryList = this.inventoryService.getAllInventories();
		if(inventoryList.size()==0)
			return new ResponseEntity<List<Inventory>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Inventory>>(inventoryList,HttpStatus.OK);
		
    }
	
	@GetMapping(value = "/item/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("id") long id ) throws Exception {
		Inventory inventory = this.inventoryService.getInventory(id);
		if(inventory==null)
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Inventory>(inventory,HttpStatus.OK);
	}
	
	@PostMapping("/item")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		Inventory createdInventory = this.inventoryService.addInventory(inventory);
		if(createdInventory!=null)
			return new ResponseEntity<Inventory>(createdInventory,HttpStatus.CREATED);
		else
			return new ResponseEntity<Inventory>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory, @PathVariable("id") long id){
		Inventory checkInventory = this.inventoryService.getInventory(id);
		if(checkInventory!=null)
		{
			this.inventoryService.deleteInventory(checkInventory);
			return new ResponseEntity<Inventory>(this.inventoryService.addInventory(inventory),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Inventory> deleteInventory(@PathVariable("id") long id) {
		Inventory checkInventory = this.inventoryService.getInventory(id);
	    if(checkInventory!=null) {
	    	this.inventoryService.deleteInventory(checkInventory);
	    	return new ResponseEntity<Inventory>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/item/")
	public ResponseEntity<Inventory> deleteAllInventory() {
		if(this.inventoryService.getAllInventories().size()!=0) {
			this.inventoryService.deleteAllInventory();
			return new ResponseEntity<Inventory>(HttpStatus.OK);
		}else
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		
	}
	/*End of Inventory Endpoints*/
}

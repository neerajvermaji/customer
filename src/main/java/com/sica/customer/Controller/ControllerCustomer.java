package com.sica.customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.sica.Product.Entity.EntityProduct;
import com.sica.customer.Entity.EntityCustomer;
import com.sica.customer.Model.Product;
import com.sica.customer.Service.ServiceCustomer;

@RestController
public class ControllerCustomer {
	@Autowired
	ServiceCustomer service;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody EntityCustomer entity) {
		return service.addCustomer(entity);
	}
	@GetMapping("/getCustomerDetail")
	public List<EntityCustomer>getCustomerDetail(){
		return service.getCustomerDetail();
	}
	@GetMapping("/getCustmoerById")
	public Optional<EntityCustomer>getCustmoerById(@RequestParam int id){
		return service.getCustmoerById(id);
	}
	@GetMapping("/getCustomerByName")
	public List<EntityCustomer>getCustomerByName(@RequestParam String name){
		return service.getCustomerByName(name);
	}
	@GetMapping("/getCustomerByAddressAndCity")
	public List<EntityCustomer>getCustomerByAddressAndCity(@RequestParam String address,@RequestParam String city){
		return service.getCustomerByAddressAndCity(address,city);
		
	}
	@DeleteMapping("/deleteCustomerById")
	public String deleteCustomerById(@RequestParam int id) {
		return service.deleteCustomerById(id);
	}
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody EntityCustomer entity) {
		return service.updateCustomer(entity);
	}
	@GetMapping("/getProductDetail")
	public Product[] getProductDetail(){
		return service.getProductDetail();
	}
	@GetMapping("/getProductById")
	public Product getProductById(@RequestParam int id){
		return service.getProductById(id);
	}
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	@PutMapping("/updateProduct")
	public  String updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@DeleteMapping("/deleteProductById")
	public String deleteProductById(@RequestParam int id) {
		return service.deleteProductById(id);
	}
	
}

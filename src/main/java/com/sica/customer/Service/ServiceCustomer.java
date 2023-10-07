package com.sica.customer.Service;

import java.util.Arrays;
//import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
//import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.farmersmart.Login.Service.LoginService;
import com.sica.customer.Entity.CustomerRepository;
import com.sica.customer.Entity.EntityCustomer;
import com.sica.customer.Model.Product;

@Service
public class ServiceCustomer {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceCustomer.class);
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RestTemplate template;

	public String addCustomer(EntityCustomer entity) {
		// TODO Auto-generated method stub
		repository.save(entity) ;
		String response = "you have been added successfully";
		logger.info(response);
		return response;
	}

	public List<EntityCustomer> getCustomerDetail() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<EntityCustomer> getCustmoerById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public List<EntityCustomer> getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	public List<EntityCustomer> getCustomerByAddressAndCity(String address, String city) {
		// TODO Auto-generated method stub
		return repository.findByAddressAndCity(address,city);
	}

	public String deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		String message;
		try {
		repository.deleteById(id);
		message= "Record has been deleted Successfully";
		logger.info(message);
	}catch(Exception e) {
		message= "invalid id"+id;
		logger.error(message);
	}return message;
	}

	public String updateCustomer(EntityCustomer entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
		return "Record has been updated Successfully";
	}

	//@SuppressWarnings("unchecked")
	public Product[] getProductDetail() {
		// TODO Auto-generated method stub
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(header);
		String url="http://localhost:8093/getProductDetail";
		Product[] products=template.exchange(url, HttpMethod.GET, entity,Product[].class).getBody();
		return products; 
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(header);
		String url="http://localhost:8091/getProductById?id="+id;
		Product products=template.exchange(url, HttpMethod.GET, entity,Product.class).getBody();
		return products;
	}

	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <Product> entity = new HttpEntity<Product>(product,header);
		String url="http://localhost:8091/addProduct";
		String result=template.exchange(url, HttpMethod.POST, entity,String.class).getBody();
		return result;
	}

	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity=new HttpEntity<Product>(product,header);
		String url="http://localhost:8091/updateProduct";
		String updated=template.exchange(url,HttpMethod.PUT, entity,String.class).getBody();
		return updated;
	}

	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(header);
		String url="http://localhost:8091/deleteProductById?id="+id;
		String results=template.exchange(url, HttpMethod.DELETE, entity,String.class).getBody();
		return results;
		
	}
	

	}
	

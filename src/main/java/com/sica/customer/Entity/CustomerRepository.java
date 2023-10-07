package com.sica.customer.Entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<EntityCustomer, Integer>{
	public List<EntityCustomer> findByName(String name);
	public List<EntityCustomer> findByAddressAndCity(String address,String city);

}

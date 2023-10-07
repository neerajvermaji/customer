	package com.sica.customer.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class EntityCustomer {
	@Id
	int id;
	String name;
	String address;
	String mobile;
	String city;
	
	public EntityCustomer() {
		super();
	}

	public EntityCustomer(int id, String name, String address, String mobile, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "EntityCustomer [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", city="
				+ city + "]";
	}
	

}

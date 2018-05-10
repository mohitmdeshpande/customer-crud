package com.customer.customercrud.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customers")
public class Customer {

	@Id
	String id;
	String custName;
	String custAddress;
	String custEEmail;
	long custMobile;
	
	
	public Customer() {
		
	}


	public Customer(String id, String custName, String custAddress, String custEEmail, long custMobile) {
		super();
		this.id = id;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custEEmail = custEEmail;
		this.custMobile = custMobile;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getCustEEmail() {
		return custEEmail;
	}


	public void setCustEEmail(String custEEmail) {
		this.custEEmail = custEEmail;
	}


	public long getCustMobile() {
		return custMobile;
	}


	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	
	
	
}

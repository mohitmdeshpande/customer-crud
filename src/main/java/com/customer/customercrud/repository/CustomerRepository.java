package com.customer.customercrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.customer.customercrud.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	 @Override
	    Customer findOne(String id);

	    @Override
	    void delete(Customer deleted);

}

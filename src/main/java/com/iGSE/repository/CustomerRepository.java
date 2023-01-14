package com.iGSE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iGSE.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public boolean existsByEmail(String email);

	public Customer findByEmail(String email);
	

}

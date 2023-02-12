package com.example.customerhateoas.dao;

import com.example.customerhateoas.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {
}

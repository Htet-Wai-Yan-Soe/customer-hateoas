package com.example.customerhateoas.dao;

import com.example.customerhateoas.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address,Integer> {
}

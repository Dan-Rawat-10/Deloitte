package com.pms.deloitte.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.deloitte.model.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product,Integer>{

}

package com.myretail.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myretail.domain.Price;

public interface ProductRepository extends CrudRepository<Price, Long> {
	@Query("Select * from Price where product_id=?0")
	Price findByProductId(long id);
}

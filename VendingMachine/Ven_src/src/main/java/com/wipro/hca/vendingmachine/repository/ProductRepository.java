package com.wipro.hca.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.hca.vendingmachine.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Modifying
	@Query("update Product product set product.quantity = ?1 where product.id = ?2")
    Integer updateProductQuantity(Integer quantity, Long id);
}

package com.wipro.hca.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.hca.vendingmachine.entity.ProductSales;

@Repository
public interface ProductSalesRepository extends JpaRepository<ProductSales, Long> {

}

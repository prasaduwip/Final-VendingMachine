package com.wipro.hca.vendingmachine.service;

import java.util.List;

import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;

/**
 * Service class to provide API for Vending Machine
 */
public interface VendingMachineService {  

	public Product getProductDetails(Long id);
	
	public List<ProductSales> getProductSales();
	
	public List<Product> getAvailableProducts();
	
	public Integer updateProductQuantity(Product product);
	
}


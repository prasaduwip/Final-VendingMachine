package com.wipro.hca.vendingmachine.service;

import java.util.List;

import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;

public interface ProductService {

	public Product addProduct(Product product);
	public Product getProduct(Long id);
	public Product updateProduct(Product product);
	public List<Product> getAvailableProducts();
	public List<Product> getAllProducts();	
	public Product updateProductQuantity(Product product);
	public List<ProductSales> getProductSales();

}

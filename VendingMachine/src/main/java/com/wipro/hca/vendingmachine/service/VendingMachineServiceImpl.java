package com.wipro.hca.vendingmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

	@Autowired
	private ProductService productService;

	@Override
	public Product getProductDetails(Long id) {
		return productService.getProduct(id);
	}

	@Override
	public List<ProductSales> getProductSales() {
		return productService.getProductSales();
	}

	@Override
	public List<Product> getAvailableProducts() {
		return productService.getAvailableProducts();
	}

	@Override
	public Integer updateProductQuantity(Product product) {
		return productService.updateProductQuantity(product) !=null ? 1 : -1;
	}
}

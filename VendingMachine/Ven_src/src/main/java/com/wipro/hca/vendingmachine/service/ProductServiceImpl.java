package com.wipro.hca.vendingmachine.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;
import com.wipro.hca.vendingmachine.repository.ProductRepository;
import com.wipro.hca.vendingmachine.repository.ProductSalesRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductSalesRepository productSalesRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAvailableProducts() {
		return productRepository.findAll().stream().filter(product -> product.getQuantity() > 0).collect(Collectors.toList());
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public Product updateProductQuantity(Product product) {
		productRepository.updateProductQuantity(product.getQuantity(), product.getId());
		final ProductSales productSales = new ProductSales();
		productSales.setProductId(product.getId());
		productSales.setProductName(product.getName());
		productSales.setProductQuantity(product.getQuantity());
		productSalesRepository.save(productSales);
		return product;
	}

	@Override
	public List<ProductSales> getProductSales() {
		return productSalesRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

}

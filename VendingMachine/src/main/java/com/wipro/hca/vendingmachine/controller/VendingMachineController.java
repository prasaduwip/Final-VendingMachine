package com.wipro.hca.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;
import com.wipro.hca.vendingmachine.service.VendingMachineService;

@RestController
public class VendingMachineController {

	@Autowired
	private VendingMachineService vendingMachineService;

	@GetMapping("/vendingmachine/getAvailableProducts")
	public List<Product> getAvailableProducts() {
		return vendingMachineService.getAvailableProducts();
	}

	@PostMapping(value="/vendingmachine/updateProductQuantity")
	public ResponseEntity<Product> updateProductQuantity(@RequestBody Product product) {
		vendingMachineService.updateProductQuantity(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/vendingmachine/getProductSales")
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		List<ProductSales> productSales = vendingMachineService.getProductSales();
		modelAndView.addObject("productSales", productSales);
		modelAndView.setViewName("productSales");
		return modelAndView; 
	}

	@GetMapping("/getProductDetails/{id}")
	public Product getProductDetails(@PathVariable("id") Long id) {
		return vendingMachineService.getProductDetails(id);
	}

	@GetMapping("/getProductSales")
	public List<ProductSales> getProductSales() {
		return vendingMachineService.getProductSales();
	}

}

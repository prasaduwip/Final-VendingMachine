package com.wipro.hca.vendingmachine;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.hca.vendingmachine.bootstrap.VendingMachineApplication;
import com.wipro.hca.vendingmachine.controller.VendingMachineController;
import com.wipro.hca.vendingmachine.entity.Product;
import com.wipro.hca.vendingmachine.entity.ProductSales;
import com.wipro.hca.vendingmachine.service.VendingMachineService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {VendingMachineApplication.class})
public class VendingMachineApplicationTests {

	final String baseURL = "http://localhost:8070/hcaservices/";

	TestRestTemplate testRestTemplate = new TestRestTemplate();

	@InjectMocks
	VendingMachineController vendingMachineController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testInsertCoin() {

		/*final String url = baseURL+"insertCoin";

		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Coin> request = new HttpEntity<Coin>(Coin.QUARTER, headers);
		ResponseEntity<String> result = testRestTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<String>(){});

		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		String resp = result.getBody();
		Assert.assertEquals(resp, Coin.QUARTER.toString()+" inserted successfully");*/
	}

	@Test
	public void testRemoveCoins() {

	}

	@Test
	public void testGetProductDetails() {

	}

	@Test
	public void testDispenseProduct() {

	}

	@Test
	public void testGetProductSales() {

	}

	@Test
	public void testGetAvailableProducts() {

	}

}

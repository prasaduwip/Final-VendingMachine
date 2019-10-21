package com.wipro.hca.vendingmachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = -6551899955968010511L;

	@Id
	@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false, unique = true, insertable = false, updatable = false)
	private Long id;
	
	private String name;
	private Double price;
	private Integer quantity;	
	private String size;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (!(obj instanceof Product)) {
			return false;
		} else if (obj instanceof Product) {
			Product product = (Product) obj;
			return product.getId().equals(this.getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

}

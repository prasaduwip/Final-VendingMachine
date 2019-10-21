package com.wipro.hca.vendingmachine.entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ProductSales implements Serializable {
	
	private static final long serialVersionUID = -6551899955968010511L;

	@Id
	@SequenceGenerator(name = "PRODUCTSALES_SEQ", sequenceName = "PRODUCTSALES_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PRODUCTSALES_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false, unique = true, insertable = false, updatable = false)
	private Long id;
	
	private Long productId;
	private String productName;
	private Integer productQuantity;
	
	@Column(name = "PURCHASE_DATE", unique = true, updatable = false)
	@CreationTimestamp
	protected LocalDateTime purchaseDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (!(obj instanceof ProductSales)) {
			return false;
		} else if (obj instanceof ProductSales) {
			ProductSales product = (ProductSales) obj;
			return product.getId().equals(this.getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
}

package com.music.musicweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productId;
	
	String productName;
	String productDesc;
	
	@Transient
	MultipartFile prodimage;
	
	int stock;
	int price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="categoryid")
	private Category category;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public MultipartFile getProdimage() {
		return prodimage;
	}

	public void setProdimage(MultipartFile prodimage) {
		this.prodimage = prodimage;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}

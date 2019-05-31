package com.myretail.domain;

import java.io.Serializable;


public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	public Product() {
	}
	private long product_id;
	private String name;
    private Price price;
    
    
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}

    
}

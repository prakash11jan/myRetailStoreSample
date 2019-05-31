package com.myretail.form;

import java.io.Serializable;


public class ProductForm implements Serializable{

	private static final long serialVersionUID = 1L;

	public ProductForm() {
	}
	private long product_id;
	private String name;
    private PriceForm price;
    
    
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
	public PriceForm getPrice() {
		return price;
	}
	public void setPrice(PriceForm price) {
		this.price = price;
	}

    
}

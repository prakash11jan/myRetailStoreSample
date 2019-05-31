package com.myretail.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("Price")
public class Price {
	@PrimaryKey("product_id")
   // @CassandraType(type = DataType.Name.BIGINT)
    private long product_id;
	@Column("value")
    private double value;
	
	@Column("currency_code")
	private String currency_code;
   
    
    public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	

   
}

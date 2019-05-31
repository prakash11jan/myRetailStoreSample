package com.myretail.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myretail.domain.Price;
import com.myretail.form.PriceForm;


@Component
public class PriceToPriceFormConverter implements Converter<Price,PriceForm> {

	@Override
	public PriceForm convert(Price price) {
		 PriceForm priceForm = new PriceForm();
		 priceForm.setProduct_id(price.getProduct_id());
		 priceForm.setValue(price.getValue());
		 priceForm.setCurrency_code(price.getCurrency_code());
		return priceForm;
	}

	
}

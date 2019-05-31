package com.myretail.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myretail.domain.Price;
import com.myretail.form.PriceForm;


@Component
public class PriceFormToPriceConverter implements Converter<PriceForm,Price> {

	@Override
	public Price convert(PriceForm priceForm) {
		Price price = new Price();
		price.setProduct_id(priceForm.getProduct_id());
		price.setValue(priceForm.getValue());
		price.setCurrency_code(priceForm.getCurrency_code());
		return price;
	}

	
}

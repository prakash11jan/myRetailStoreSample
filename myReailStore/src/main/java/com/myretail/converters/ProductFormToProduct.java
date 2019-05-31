package com.myretail.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myretail.domain.Product;
import com.myretail.form.PriceForm;
import com.myretail.form.ProductForm;


@Component
public class ProductFormToProduct implements Converter<Product,ProductForm> {
	@Autowired
	private PriceToPriceFormConverter priceToPriceFormConverter;
    @Override
    public ProductForm convert(Product product) {
    	ProductForm productForm = new ProductForm();
    	productForm.setProduct_id(product.getProduct_id());
    	productForm.setName(product.getName());
    	PriceForm priceForm = priceToPriceFormConverter.convert(product.getPrice());
    	productForm.setPrice(priceForm);
        return productForm;
    }
}

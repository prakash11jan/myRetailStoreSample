package com.myretail.services;

import java.util.List;
import java.util.UUID;

import com.myretail.domain.Product;
import com.myretail.form.PriceForm;
import com.myretail.form.ProductForm;


public interface ProductService {


    ProductForm findByProductId(long id);


	ProductForm updatePriceById(Long id, PriceForm priceForm);

}

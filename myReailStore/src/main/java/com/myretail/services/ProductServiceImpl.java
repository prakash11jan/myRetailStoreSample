package com.myretail.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.myretail.converters.PriceFormToPriceConverter;
import com.myretail.converters.ProductFormToProduct;
import com.myretail.domain.Price;
import com.myretail.domain.Product;
import com.myretail.form.PriceForm;
import com.myretail.form.ProductForm;
import com.myretail.repositories.ProductRepository;
import com.myretail.utils.WebServiceUtil;


@PropertySource({ "classpath:application.properties" })
@Service
public class ProductServiceImpl implements ProductService {

    private Environment env;
    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;
    @Autowired
    PriceFormToPriceConverter priceFormToPriceConverter;
    private final String restUrl = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomyprice,price,package_dimensions,promotion,manufacturer,bulk_ship,available_to_promise_network,bundle_components,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels";

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct,Environment env) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
        this.env = env;
    }



    @Override
    public ProductForm findByProductId(long id) {
    	Price price = findpriceFromCassandra(id);
    	String name = getNameFromTargetService(id);
    	
    	Product product = new Product();
    	product.setName(name);
    	product.setProduct_id(id);
    	product.setPrice(price);
    	ProductForm productForm = productFormToProduct.convert(product);
    	return productForm;
    }

    private String getNameFromTargetService(long productId) {
    	String urlToBeInvoked = env.getProperty("target.service.url") + productId+ "?excludes"+env.getProperty("targer.service.exclude.list");
    	String response = WebServiceUtil.invokeRest(urlToBeInvoked);
    	String productName = WebServiceUtil.getNameFromResponse(response);
		return productName;
	}


	private Price findpriceFromCassandra(long id) {
    	Price price =  productRepository.findByProductId(id);
		return price;
		
	}


/*
 * updating price in cassandra DB and returns the same products to acknowledge the user
 * @see com.myretail.services.ProductService#updatePriceById(java.lang.Long, com.myretail.form.PriceForm)
 */
	@Override
	public ProductForm updatePriceById(Long id, PriceForm priceForm) {
		Price price = priceFormToPriceConverter.convert(priceForm);
		price =  productRepository.save(price);//price updated in Cassadra DB
		return findByProductId(id);//fetching results to acknowledge the user
		
	}





    
}

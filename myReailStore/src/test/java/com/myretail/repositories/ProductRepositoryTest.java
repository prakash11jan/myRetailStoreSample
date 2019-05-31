package com.myretail.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myretail.domain.Price;
import com.myretail.form.ProductForm;
import com.myretail.services.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testService() {
    	ProductForm productForm = productService.findByProductId(13860428);
        Assert.assertEquals(13860428, productForm.getProduct_id());
    }
    @Test
    public void testRepository() {
    	Price price = productRepository.findByProductId(13860428);
        Assert.assertEquals(13860428, price.getProduct_id());
    }
}
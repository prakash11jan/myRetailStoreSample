package com.myretail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.form.PriceForm;
import com.myretail.form.ProductForm;
import com.myretail.services.ProductService;


@RestController
public class ProductController implements ErrorController{
	private static final String PATH = "/error";
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ProductForm getProduct(@PathVariable long id){
    	ProductForm productForm = productService.findByProductId(id);
        return productForm;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ProductForm updatePrice(@PathVariable Long id,@RequestBody PriceForm priceForm){
    	ProductForm productForm = productService.updatePriceById(id,priceForm);
        return productForm;
    }
   

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

  
   
    
    @RequestMapping(value = PATH)
    public String error() {
        return "oops!! something went wrong try again later!!";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

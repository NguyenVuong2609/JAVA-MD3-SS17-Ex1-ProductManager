package Rikkei.academy.controller;

import Rikkei.academy.model.Product;
import Rikkei.academy.service.ProductService.IProductService;
import Rikkei.academy.service.ProductService.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMPL();
    public List<Product> getListProduct(){
        return productService.findAll();
    }
    public void addProduct(Product product){
        productService.save(product);
    }
}

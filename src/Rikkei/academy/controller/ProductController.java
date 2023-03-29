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

    public Product findById(int id){
        return productService.findById(id);
    }

    public void updateProduct(Product product){
        productService.save(product);
    }
    public void deleteProduct(int id){
        productService.deleteById(id);
    }
}

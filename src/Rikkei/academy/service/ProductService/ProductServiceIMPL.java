package Rikkei.academy.service.ProductService;

import Rikkei.academy.config.Config;
import Rikkei.academy.model.Product;

import java.util.List;

public class ProductServiceIMPL implements IProductService {
    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}

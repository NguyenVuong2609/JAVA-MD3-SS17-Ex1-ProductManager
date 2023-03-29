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
        if (findById(product.getId()) == null) {
            productList.add(product);
        } else {
//            Product product1 = findById(product.getId());
//            product1.setProductName(product.getProductName());
//            product1.setBrand(product.getBrand());
//            product1.setDescription(product.getDescription());
//            product1.setPrice(product.getPrice());
            int index = productList.indexOf(findById(product.getId()));
            productList.set(index,product);
        }
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        int index = productList.indexOf(findById(id));
        productList.remove(index);
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }
}

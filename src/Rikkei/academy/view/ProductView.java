package Rikkei.academy.view;

import Rikkei.academy.config.Config;
import Rikkei.academy.controller.ProductController;
import Rikkei.academy.model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListProduct();

    public void showProductList() {
        System.out.println(productList);
        System.out.println("Enter any key to quit or BACK to return Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar();
        }
    }

    public void addProduct() {
        while (true) {
            try {
                int id = 0;
                if (productList.size() == 0) {
                    id = 1;
                } else {
                    id = productList.get(productList.size() - 1).getId() + 1;
                }
                System.out.println("Enter the Product name: ");
                String name = Config.scanner().nextLine();
                System.out.println("Enter the brand: ");
                String brand = Config.scanner().nextLine();
                System.out.println("Enter the price: ");
                Float price = Float.parseFloat(Config.scanner().nextLine());
                System.out.println("Enter the description: ");
                String description = Config.scanner().nextLine();
                Product product = new Product(id, name, brand, price, description);
                productController.addProduct(product);
                System.out.println("Add success!");
                System.out.println("Enter any key to continue or BACK to return Menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void findProduct() {
        while (true) {
            try {
                System.out.println("Enter the productId that you want to find: ");
                int id = Integer.parseInt(Config.scanner().nextLine());
                Product target = productController.findById(id);
                if (target != null) {
                    System.out.println("Your result --> : " + target);
                } else {
                    System.out.println("This product does not exist.");
                }
                System.out.println("Enter any key to continue or BACK to return Menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

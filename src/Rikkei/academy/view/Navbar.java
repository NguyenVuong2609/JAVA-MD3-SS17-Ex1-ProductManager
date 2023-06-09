package Rikkei.academy.view;

import Rikkei.academy.config.Config;

public class Navbar {
    public Navbar(){
        System.out.println("********************* Product Management *********************");
        System.out.println("1. Show list Product\n" +
                "2. Add Product\n" +
                "3. Find product by Id\n" +
                "4. Update product\n" +
                "5. Delete product by Id");
        System.out.println("Please enter your choice: ");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                new ProductView().showProductList();
                break;
            case 2:
                new ProductView().addProduct();
                break;
            case 3:
                new ProductView().findProduct();
                break;
            case 4:
                new ProductView().updateProduct();
                break;
            case 5:
                new ProductView().deleteProduct();
                break;
        }
    }
    public static void main(String[] args) {
        new Navbar();
    }
}

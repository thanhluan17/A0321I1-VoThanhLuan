package b12_java_collection_framework.bai_tap.product_management_array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private static List<Product> productList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        productList = new ArrayList<>();
        productList.add(new Product(3, "Iphone", 2000));
        productList.add(new Product(1, "Samsung", 1500));
        productList.add(new Product(2, "Xiaomi", 1000));
    }

    public static void displayMenu() {
        int selection = -1;
        do {
            System.out.println("=====Product Management=====");
            System.out.println("1. Display product list");
            System.out.println("2. Add new a product");
            System.out.println("3. Update a product");
            System.out.println("4. Delete a product");
            System.out.println("5. Search a product");
            System.out.println("6. Sort product list");
            System.out.println("7. Exit");
            System.out.println("Enter your selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    ProductManagement.displayListProduct();
                    break;
                case 2:
                    ProductManagement.addProduct();
                    break;
                case 3:
                    ProductManagement.updateProduct();
                    break;
                case 4:
                    ProductManagement.deleteProduct();
                    break;
                case 5:
                    ProductManagement.searchProduct();
                    break;
                case 6:
                    ProductManagement.sortProductList();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayListProduct() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public static void addProduct() {
        int id;
        do {
            System.out.println("Enter product id: ");
            id = scanner.nextInt();
            if (findById(id) != null) {
                System.out.println("Id exist! Enter again!");
            }
        } while (findById(id) != null);
        scanner.skip("\\R");
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        productList.add(new Product(id, name, price));
        System.out.println("Success!");
    }

    public static void updateProduct() {
        int id;
        do {
            System.out.println("Enter product id to update: ");
            id = scanner.nextInt();
            if (findById(id) == null) {
                System.out.println("Id not exist! Enter again!");
            }
        } while (findById(id) == null);
        Product product = findById(id);
        System.out.println(product.toString());
        scanner.skip("\\R");
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new price: ");
        double price = scanner.nextDouble();
        product.setName(name);
        product.setPrice(price);
        System.out.println("Success!");
    }

    public static void deleteProduct() {
        System.out.println("Enter product id to delete: ");
        int id = scanner.nextInt();
        if (findById(id) == null) {
            System.out.println("Can't find product! ");
        } else {
            Product product = findById(id);
            productList.remove(product);
        }
        System.out.println("Success!");
    }

    public static void searchProduct() {
        System.out.println("Enter id to search: ");
        int id = scanner.nextInt();
        if (findById(id) == null) {
            System.out.println("Can't find product! ");
        } else {
            Product product = findById(id);
            System.out.println(product.toString());
        }
    }

    public static void sortProductList() {
        System.out.println("1. to AscendingSort!\n 2. to DescendingSort!");
        System.out.println("Enter your selection: ");
        int selection = scanner.nextInt();
        if (selection == 1) {
            AscendingSort ascendingSort = new AscendingSort();
            Collections.sort(productList, ascendingSort);
            ProductManagement.displayListProduct();
        }
        if (selection == 2) {
            DescendingSort ascendingSort = new DescendingSort();
            Collections.sort(productList, ascendingSort);
            ProductManagement.displayListProduct();
        }
    }

    public static Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

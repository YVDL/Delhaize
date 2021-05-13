package com.delhaize;

import com.delhaize.domain.*;
import com.delhaize.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Delhaize{
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    private AddingToDBService addingToDBService = new AddingToDBService();
    private ProductService productService = new ProductService();
    private DeletingFromDBService deletingFromDBService = new DeletingFromDBService();
    private StoreService storeService = new StoreService();
    private CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        Delhaize delhaize = new Delhaize();

        delhaize.showInitialOptions();
    }

    public void showInitialOptions() {
        System.out.println("Please select an option: " +
                "\n0. Quit!" +
                "\n1. Fill up database" +
                "\n2. Remove from database" +
                "\n3.");


        String choice = scanner.next();

        switch (choice) {
            case "0":
                System.exit(0);
            case "1":
                chooseClassToAdd();
                break;
            case "2":
                chooseClassToDelete();
                break;
            case "3":
                makeOrder();
                break;
            case "4":
                showListOfProducts();
                break;
            case "5":

        }
    }

    private void showListOfProducts() {
        System.out.println("Do you want a complete stock list or a stock list from a distinct store?" +
                "\n 1.complete list" +
                "\n 2. Distinct store");
                int choice = scanner.nextInt();
        if (choice == 1){
            List<Product>productList = productService.listOfProducts();
            for(Product p : productList){
                System.out.println(p.getId() + p.getProductName());
            }
        }else{
            System.out.println("Give the id of the store you want the product list from");
            List<Store> storeList = storeService.getStores();
            for (Store s : storeList){
                System.out.println(s.getId() + " " + s.getStoreName());
            }
            int storeId = scanner.nextInt();
            List<Product>productList = productService.listOfDistinctShopProducts(storeId);
            for (Product p : productList){
                System.out.println(p.toString());
            }
        }
    }

    private void makeOrder() {
        List<Customer>customerList = customerService.showAllCustomers();
        for(Customer c : customerList){
            System.out.println(c.getId() + " " + c.getName());
        }
        System.out.println("Give the id of the customer you are making the order for.");
        int customerId = scanner.nextInt();
        List<Product> orderList = new ArrayList<>();
        boolean wanneEnd = false;
        while(wanneEnd == false){
            List<Product> productList = productService.listOfProducts();
            for(Product p : productList){
                System.out.println(p.getId() + " " + p.getProductName() + " " + p.getRetailPrice() + " " + p.getQuantity());
            }
            System.out.println("Choose a product by id:");
            int productId = scanner.nextInt();
            System.out.println("Choose the quantity:");
            int quantity = scanner.nextInt();
        }
    }

    private void chooseClassToDelete() {
        System.out.println("Please select a class to remove item from: " +
                "\n0. Go back" +
                "\n1. Products" +
                "\n2. Products"
        );


        String choice = scanner.next();
        switch (choice) {
            case "0":
                showInitialOptions();
                break;
            case "1":
                deleteProductById();
                break;
        }
    }

    private void chooseClassToAdd() {
        System.out.println("Please select class object to add to database\n" +
                "0. Go back\n" +
                "1. Category\n" +
                "2. Delete products\n"
        );

String choice = scanner.next();

        switch (choice) {
            case "0":
                showInitialOptions();
                break;
            case "1":
                addProduct();
                break;
        }
    }

    private void addProduct() {
        System.out.println("Please select a category" +
                "\n1. Food" +
                "\n2. Cleaning" +
                "\n3. Personal care" +
                "\n4. Drinks" +
                "\n5. PetFood ");
        Category category = addingToDBService.getCategoryById(scanner.nextInt());
        System.out.println("What is the name of the product?");
        String name = scanner.next();



        System.out.println("Type in the description of the product: ");
        String description = scanner.nextLine();
        scanner.nextLine();

        System.out.println("What is the retail price of the product?");
        double retail = scanner.nextDouble();

        System.out.println("What price do you want to sell the product for?");
        double price = scanner.nextDouble();

        System.out.println("How many are in stock?");
        int stock = scanner.nextInt();

        System.out.println("Type in the id of the store you want the product to be delivered");

        List<Store> storeList = storeService.getStores();
        for (Store s : storeList){
            System.out.println(s.getId() + " " + s.getStoreName());
        }

        int storeId = scanner.nextInt();

        addingToDBService.addProductToDB(Product.builder()
                .productName(name)
                .wholeSale(price)
                .retailPrice(retail)
                .quantity(stock)
                .description(description)
                .category(category)
                .store(Store.builder().id(storeId).build())
                .build());
        System.out.println("Do you want to add another product?" +
                "\n1. Yes" +
                "\n2. No");
        String choice = scanner.next();
        if (choice.equals(("1"))) {
            addProduct();
        }else{
            showInitialOptions();
        }
    }


    private void deleteProductById() {

        System.out.println();
        List<Product> productList = productService.listOfProducts();
        for(Product p : productList){
            System.out.println(p.getId() + "\t" + p.getProductName());
        }
        System.out.println("Enter the id of the product you want to remove");
        deletingFromDBService.deleteProductById(scanner.nextInt());
        showInitialOptions();
        }
    }


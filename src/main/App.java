package main;
import java.util.Scanner;
import Exceptions.ProductListException;
import Exceptions.QueueException;
import Facade.ClienteDataBase;
import Facade.OrderQueue;
import Facade.ProductList;
import Strategy.CreditCardStrategy;
import interfaces.Client;
import interfaces.Product;

public class App {

    public static void showMenu() {

        System.out.println("Settings:");
        System.out.println("1 - Register new client Account");
        System.out.println("2 - Log in client");
        System.out.println("3 - Register new product");
        System.out.println("4 - View Product data by id");
        System.out.println("5 - View produt database");
        System.out.println("6 - Set price");
        System.out.println("7 - Set stock quantity:");
        System.out.println("8 - Remove Product by id");
        System.out.println("9 - Add to cart");
        System.out.println("10 - Process shopping cart");
        System.out.println("11 - Paymento mehtod");
        System.out.println("0 - Close application");
        System.out.println("Choose an option");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String id;
        String name;
        String password;
        Client tempClient = null;
        ProductList productDataBase = new ProductList();
        OrderQueue shoppingCart = new OrderQueue();
        ClienteDataBase clientAccounts = new ClienteDataBase();
        int operator;

        do {

            showMenu();
            operator = input.nextInt();
            input.nextLine();

            if (operator == 1) {

                System.out.println("Please inform client id: ");
                id = input.nextLine();

                System.out.println("Please inform client name: ");
                name = input.nextLine();

                System.out.println("Please inform client password: ");
                password = input.nextLine();

                tempClient = new Client(id, name, password);
                clientAccounts.registerClient(tempClient);
                

            }

            if (operator == 2) {

                System.out.println("Please inform client id: ");
                id = input.nextLine();

                System.out.println("Please inform client password: ");
                password = input.nextLine();

                if (clientAccounts.passwordCheck(id, password)) {

                    System.out.println("Passowrd verified");
                    tempClient = clientAccounts.getClient(id);

                } else {

                    System.out.println("Id or password incorrect");
                }

            }

            if (operator == 3) {

                System.out.println("Please inform produt Id:");
                String productId = input.nextLine();

                System.out.println("Please inform produt name:");
                String productName = input.nextLine();


                System.out.println("Please set a price");
                double productPrice = input.nextDouble();

                Product newProduct = new Product(productId, productName);
                newProduct.setPrice(productPrice);

                productDataBase.registerProduct(newProduct);

            }

            if (operator == 4) {

                System.out.println("Input product id");
                String productId = input.nextLine();

                productDataBase.showProducInfo(productId);

            }

            if (operator == 5) {

                productDataBase.showStock();
            }

            if (operator == 6) {

                System.out.println("Input product id");
                String productId = input.nextLine();

                System.out.println("Enter new price");
                double price = input.nextInt();

                productDataBase.setPrice(productId, price);

            }

            if (operator == 7) {

                System.out.println("Input product id");
                String productId = input.nextLine();

                System.out.println("Enter new stock quantity");
                int stock = input.nextInt();

                productDataBase.setStock(productId, stock);

            }

            if (operator == 9) {

                System.out.println("Input product id");
                String productId = input.nextLine();
                Product tempProduct;

                try {

                    tempProduct = productDataBase.getProduct(productId);
                    shoppingCart.insertProduct(tempProduct);

                } catch (ProductListException ae) {
                    System.out.println(ae.getMessage());

                } catch (QueueException e) {
                    System.out.println(e.getMessage());

                }

            }

            if (operator == 10) {

                System.out.println("input card number");
                String cardnumber = input.nextLine();

                System.out.println("input cvv");
                String cvv = input.nextLine();

                System.out.println("input expiration date");
                String dateExp = input.nextLine();

                try {

                    shoppingCart.pay(new CreditCardStrategy(tempClient.getName(), cardnumber, cvv, dateExp));
                    
                } catch (QueueException e) {

                    System.out.println(e.getMessage());
                }

            }

        } while (operator != 0);

        input.close();

    }

}

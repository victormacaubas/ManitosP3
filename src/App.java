import java.util.Scanner;
import bases
import Exceptions.ProductListException;
import Exceptions.QueueException;

public class App {

    public static void showMenu() {

        System.out.println("Settings:");
        System.out.println("1 - Register new client Account");
        System.out.println("2 - Verify client password");
        System.out.println("3 - Register new product");
        System.out.println("4 - View Product data by id");
        System.out.println("5 - View produt database");
        System.out.println("6 - Set price");
        System.out.println("7 - Set stock quantity:");
        System.out.println("8 - Remove Product by id");
        System.out.println("9 - Add to cart");
        System.out.println("10 - Process shopping cart");
        System.out.println("0 - Close application");
        System.out.println("Choose an option");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String id;
        String name;
        String password;
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

                Client tempClient = new Client(id, name, password);
                clientAccounts.registerClient(tempClient);

            }

            if (operator == 2) {

                System.out.println("Please inform client id: ");
                id = input.nextLine();

                System.out.println("Please inform client password: ");
                password = input.nextLine();

                if (clientAccounts.passwordCheck(id, password)) {

                    System.out.println("Passowrd verified");

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

                System.out.println("Processing order...");

                try {

                    for (int i = 0; i < shoppingCart.orderSize(); i++) {

                        shoppingCart.processProduct();

                    }
                    
                } catch (QueueException e) {

                    System.out.println(e.getMessage());
                }

            }

        } while (operator != 0);

        input.close();

    }

}

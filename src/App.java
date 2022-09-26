import java.util.Scanner;

public class App {

    public static void showMenu() {

        System.out.println("Settings:");
        System.out.println("1 - Register new Product on first position");
        System.out.println("2 - Register new Product on last position");
        System.out.println("3 - View Products in P2 class");
        System.out.println("4 - View Product data by id");
        System.out.println("5 - Set price");
        System.out.println("6 - Set number of stock:");
        System.out.println("7 - Remove Product by id");
        System.out.println("8 - Remove duplicates");
        System.out.println("0 - Close application");
        System.out.println("Choose an option");

    }

    private static void insertProduct(Scanner input, int index, LinkedListProduct classDataP2) {
        Product st1;
        String name;
        String id;

        System.out.println("Input Product name");
        name = input.nextLine();

        System.out.println("Input Product id");
        id = input.nextLine();

        st1 = new Product(id, name);

        if (index == 1) {
            classDataP2.insertProductFirst(st1);
        }
        if (index == 2) {
            classDataP2.insertProductLast(st1);
        }

    }

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        LinkedListProduct classDataP2 = new LinkedListProduct();
        int operator;

        do {

            showMenu();
            operator = input.nextInt();
            input.nextLine();

            if (operator == 1) {

                insertProduct(input, operator, classDataP2);
                continue;

            }

            if (operator == 2) {

                insertProduct(input, operator, classDataP2);
                continue;

            }

            if (operator == 3) {

                classDataP2.showData();
                continue;

            }

            if (operator == 4) {

                System.out.println("Input product id");
                String id = input.nextLine();

                classDataP2.productInfo(id);
                continue;
            }

            if (operator == 5) {

                System.out.println("Input product id");
                String id = input.nextLine();

                System.out.println("Enter new price");
                double price = input.nextDouble();

                classDataP2.productPrice(id, price);
                continue;

            }

            if (operator == 6) {

                System.out.println("Input product id");
                String id = input.nextLine();

                System.out.println("Enter stock quantity");
                int stock = input.nextInt();

                classDataP2.productStock(id, stock);
                continue;

            }

            if (operator == 7) {

                System.out.println("Input product id");
                String id = input.nextLine();

                classDataP2.removeByKey(id);

            }

            if (operator == 8) {

                System.out.println("Input product id");
                String id = input.nextLine();

                classDataP2.removeRepeated(id);

            }

        } while (operator != 0);

        input.close();

    }

}

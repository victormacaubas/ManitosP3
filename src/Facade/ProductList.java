package Facade;
import ADT.DoublyLinkedList;
import ADT.DoublyNode;
import Exceptions.ProductException;
import Exceptions.ProductListException;
import interfaces.Product;

public class ProductList {

    private DoublyLinkedList<Product> productStock;

    public ProductList() {

        this.productStock = new DoublyLinkedList<>();
    }

    public void registerProduct(Product data) throws ProductException {

        DoublyNode<Product> result = this.productStock.search(data);

        if (result == null) {

            data.setProductStock(1);
            this.productStock.insertCrescentOrder(data);
            

        } else {

            result.getInfo().addStock();
        }

    }

    public void showStock() {

        this.productStock.showData();
    }


    public void showProducInfo(String id) {

        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);

        if (result != null) {

            System.out.println(result.getInfo());

        } else {

            System.out.println("Produt not found\n");
        }

    }

    public void setPrice (String id, double price) throws ProductException {

        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);

        if (result != null) {

            result.getInfo().setPrice(price);
            System.out.println("Price updated\n");

        } else {

            System.out.println("Produt not found\n");
        }
    }

    public void setStock (String id, int stock) throws ProductException {

        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);

        if (result != null) {

            result.getInfo().setProductStock(stock);
            System.out.println("Price updated");

        } else {

            System.out.println("Produt not found\n");
        }

    }

    public Product getProduct(String id) throws ProductListException, ProductException {

        Product checkOut;
        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);
        

        if (result == null) {

            throw new ProductListException("ERROR: Product not found\n");

        }

        if (result != null && result.getInfo().getProductStock() == 0) {
            
            throw new ProductListException("ERROR: Product out of stock");
        }

        result.getInfo().attStock();

        checkOut = new Product(result.getInfo().getId(), result.getInfo().getName());
        checkOut.setPrice(result.getInfo().getPrice());

        return checkOut;

    }

    public void removeProduct(String id) {

        Product aux = new Product(id);
        this.productStock.removeById(aux);

    }





}

import Exceptions.ProductListException;

public class ProductList {

    private DoublyLinkedList<Product> productStock;

    public ProductList() {

        this.productStock = new DoublyLinkedList<>();
    }

    public void registerProduct(Product data) {

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

            System.out.println("Produt not found");
        }

    }

    public void setPrice (String id, double price) {

        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);

        if (result != null) {

            result.getInfo().setPrice(price);
            System.out.println("Price updated");

        } else {

            System.out.println("Produt not found");
        }
    }

    public void setStock (String id, int stock) {

        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);

        if (result != null) {

            result.getInfo().setProductStock(stock);
            System.out.println("Price updated");

        } else {

            System.out.println("Produt not found");
        }

    }

    public Product getProduct(String id) throws ProductListException {

        Product checkOut;
        Product aux = new Product(id);
        DoublyNode<Product> result = this.productStock.search(aux);
        

        if (result == null) {

            throw new ProductListException("Product not found");

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

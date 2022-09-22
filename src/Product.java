public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;
    private int productStock;

    public Product(String id, String name, double price, int productStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productStock = productStock;
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id) {
        this.id = id;
    }

    public String toString() {

        return "(Product id: " + this.id + ") " + "(Product name: " + this.name + ") " + "(Price: " + this.price + ") " + "(In stock: " + this.productStock + ")";

    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Override
    public int compareTo(Product ProductData) {
        int result;

        result = this.getId().compareToIgnoreCase(ProductData.getId());

        return result;
    }
}
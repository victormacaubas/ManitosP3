package interfaces;

import Exceptions.ProductException;

public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;
    private int productStock;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id) {
        this.id = id;
    }

    public String toString() {

        return "(Product id: " + this.id + ") " + "(Product name: " + this.name + ") " + "(Price: " + this.price + ") "
                + "(In stock: " + this.productStock + ")";

    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setPrice(double price) throws ProductException {
        if (price <= 0) {

            throw new ProductException("ERROR: Price must be higher than 0");
        }

        this.price = price;
    }

    public void setProductStock(int productStock) throws ProductException {
        if (price <= 0) {
            
            throw new ProductException("ERROR: Price must be higher than 0");
        }
        
        this.productStock = productStock;
    }

    public double getPrice() {
        return this.price;
    }

    public int getProductStock() {
        return this.productStock;
    }

    public void attStock() {
        this.productStock--;
    }

    public void addStock() {
        this.productStock++;
    }

    @Override
    public int compareTo(Product ProductData) {
        int result;

        result = this.getId().compareToIgnoreCase(ProductData.getId());

        return result;
    }

}
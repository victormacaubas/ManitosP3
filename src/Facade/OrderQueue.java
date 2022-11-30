package Facade;
import ADT.Queue;
import Strategy.*;
import Exceptions.QueueException;
import interfaces.Product;

public class OrderQueue {

    private Queue<Product> productOrder;

    public OrderQueue() {

        productOrder = new Queue<>(20);

    }

    public void insertProduct(Product data) throws QueueException {
        
        if (productOrder.isFull()) {

            throw new QueueException("Queue is full at the moment");

        }

        productOrder.enQueue(data);
    }

    public int orderSize() {
       return this.productOrder.getNodeCount();
    }

    /* 
    public void processProduct() throws QueueException {

        Product data;

        if (productOrder.isEmpty()) {
            
            throw new QueueException("No orders to process");
            
        }

        data = productOrder.deQueue();
        System.out.println("Product: " + data + " Processed");
    }*/

    public double calculateTotal() throws QueueException {

        if (productOrder.isEmpty()) {
            
            throw new QueueException("No orders to process");
            
        }

        double sum = 0;

        for (int i = 0; i < this.productOrder.getNodeCount(); i++) {
            
            sum += this.productOrder.deQueue().getPrice();
        }

        return sum;

    }

    public void pay (PaymentStrategy paymentMethod) throws QueueException {
        double aumout = calculateTotal();
        paymentMethod.pay(aumout);
    }


    
}
    


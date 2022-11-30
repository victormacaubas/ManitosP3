package interfaces;
import ADT.Queue;
import Exceptions.QueueException;

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

    public void processProduct() throws QueueException {

        Product data;

        if (productOrder.isEmpty()) {
            
            throw new QueueException("No orders to process");
            
        }

        data = productOrder.deQueue();
        System.out.println("Product: " + data + " Processed");
    }


    
}
    


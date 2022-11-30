import Exceptions.QueueExpection;

public class OrderQueue {

    private Queue<Product> ProductOrder;

    public OrderQueue() {

        ProductOrder = new Queue<>(20);

    }

    public void insertProduct(Product data) throws QueueExpection {
        
        if (ProductOrder.isFull()) {

            throw new QueueExpection("Queue is full at the moment");

        }

        ProductOrder.enQueue(data);
    }

    public void processProduct() throws QueueExpection {

        Product data;

        if (ProductOrder.isEmpty()) {
            
            throw new QueueExpection("No orders to process");
            
        }

        data = ProductOrder.deQueue();
        System.out.println("Product: " + data + " On call");
    }


    
}
    


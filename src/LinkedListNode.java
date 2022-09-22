public class LinkedListNode {
    
    private Product info;
    private LinkedListNode next;

    public LinkedListNode(Product identifier) {
        this.info = identifier;

    }

    public void setInfo(Product identifier) {
        this.info = identifier;

    }

    public void setNext(LinkedListNode nextId) {
        this.next = nextId;

    }

    public Product getInfo() {

        return this.info;

    }

    public LinkedListNode getNext() {

        return this.next;

    }
}

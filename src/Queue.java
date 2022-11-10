public class Queue<T extends Comparable<T>> {

    private DoublyNode<T> first;
    private DoublyNode<T> last;
    private int size;
    private int nodeCount;

    public Queue(int size) {
        this.size = size;
    }

    public boolean isEmpty() {

        if (this.nodeCount == 0) {
            return true;
        }

        return false;
    }

    public boolean isFull() {

        if (this.nodeCount == size) {
            return true;
        }

        return false;
    }

    public void enQueue(T data) {

        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
            this.nodeCount++;

        } else {

            this.last.setNext(newNode);
            this.last = newNode;
            nodeCount++;

        }
    }

    public T deQueue() {

        DoublyNode<T> aux = this.first;

        if (this.first.getNext() == null) {

            this.first = null;
            this.last = null;
            this.nodeCount--;
            return aux.getInfo();
        }
        
    this.first = this.first.getNext();
        this.nodeCount--;

        return aux.getInfo();

    }

    public T head() {

        return this.first.getInfo();

    }
}
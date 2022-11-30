package ADT;
public class DoublyNode<T extends Comparable<T>> {

    private DoublyNode<T> prev;
    private DoublyNode<T> next;
    private T info;

    
    public DoublyNode(T info) {
        this.info = info;
    }


    public DoublyNode<T> getPrev() {
        return prev;
    }


    public void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }


    public DoublyNode<T> getNext() {
        return next;
    }


    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }


    public T getInfo() {
        return info;
    }


    public void setInfo(T info) {
        this.info = info;
    }

}

public class Stack<T> {

    private DoublyNode<T> top;

    public boolean isEmpty() {
        if (this.top == null) {
            return true;

        }

        return false;
    }
    
    public void push (T data) {
        
        DoublyNode<T> newNode = new DoublyNode<>(data);

        newNode.setNext(this.top);
        this.top = newNode;
    }

    public boolean isFull() {
        return false;
    }

    public T pop() {
        DoublyNode<T> aux = this.top;
        this.top = this.top.getNext();

        return aux.getInfo();

    }

}

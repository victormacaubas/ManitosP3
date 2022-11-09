public class Queue<T> {

    private DoublyNode<T> first;
    private DoublyNode<T> last;
    private int size;
    private int nodeCount;

    public Queue(int size) {
        this.size = size;
    }
}
public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyNode<T> first;
    private DoublyNode<T> last;
    private int nodeCount;

    public boolean isEmpty() {

        if (this.nodeCount == 0) {
            return true;

        }

        return false;

    }

    public void insertFirst(T data) {

        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (this.isEmpty()) {

            this.first = newNode;
            this.last = newNode;
            this.nodeCount++;

        } else {

            newNode.setNext(this.first);
            this.first.setPrev(newNode);
            this.first = newNode;
            this.nodeCount++;
        }

    }

    public void insertLast(T data) {

        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (this.isEmpty()) {

            this.first = newNode;
            this.last = newNode;
            this.nodeCount++;

        } else {

            this.last.setNext(newNode);
            newNode.setPrev(this.last);
            this.last = newNode;
            this.nodeCount++;

        }

    }

    public void showData() {

        DoublyNode<T> aux;

        if (this.isEmpty()) {

            System.out.println("List is empty");

        } else {

            aux = this.first;

            while (aux != null) {

                System.out.print(aux.getInfo() + " ");
                aux = aux.getNext();

            }

            System.out.println(" ");
        }
    }

    public void showDataLast() {

        DoublyNode<T> aux;

        if (this.isEmpty()) {

            System.out.println("List is empty");

        } else {

            aux = this.last;

            while (aux != null) {

                System.out.print(aux.getInfo() + " ");
                aux = aux.getPrev();

            }

            System.out.println(" ");
        }
    }
    
    
}

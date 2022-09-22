public class LinkedListProduct {

    private LinkedListNode first;

    private boolean isEmpty() {

        if (this.first == null) {
            return true;
        }

        return false;
    }

    public void insertProductFirst(Product productData) {

        LinkedListNode result = this.search(productData);

        if (result != null) {

            System.out.println("Product already in stock!");

        } else {

            LinkedListNode newNode = new LinkedListNode(productData);

            if (this.isEmpty()) {

                this.first = newNode;

            } else {

                newNode.setNext(this.first);
                this.first = newNode;

            }
            System.out.println("Product registered in stock");
        }

    }

    public void insertProductLast(Product productData) {

        LinkedListNode aux = this.first;
        LinkedListNode newNode = new LinkedListNode(productData);

        if (this.isEmpty()) {

            this.first = newNode;

        } else {

            while (aux.getNext() != null) {

                aux = aux.getNext();

            }

            aux.setNext(newNode);

        }
        System.out.println("Product registered in stock");

    }

    public void showData() {

        LinkedListNode aux = this.first;

        if (this.isEmpty()) {

            System.out.println("List it's empty");

        }

        while (aux != null) {

            System.out.println(aux.getInfo());
            aux = aux.getNext();

        }

    }

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
    public void removeHead() {

        LinkedListNode aux = this.first;

        if (this.isEmpty()) {

            System.out.println("List it's empty!");

        } else {

            aux = aux.getNext();
            this.first = aux;
            System.out.println("Product found and deleted");

        }

    }

    public void removeTail() {

        LinkedListNode aux = this.first;
        LinkedListNode prevLast = null;

        if (this.isEmpty()) {

            System.out.println("List it's empty!");

        }
        if (this.first.getNext() == null) {

            this.first = null;
            System.out.println("Product found and deleted");

        } else {

            while (aux.getNext() != null) {

                prevLast = aux;
                aux = aux.getNext();

            }

            if (prevLast == null) {

                this.first = null;
                System.out.println("Product found and deleted");

            } else {

                prevLast.setNext(null);
                System.out.println("Product found and deleted");
            }

        }

    }

    public void productInfo(String productId) {

        Product productData = new Product(productId);
        LinkedListNode result = this.search(productData);

        if (result != null) {

            System.out.println("Product Data:");
            System.out.println(result.getInfo());

        } else {

            System.out.println("Product not found in stock");
        }

    }

    public void productPrice(String productId, double Price) {

        Product productData = new Product(productId);
        LinkedListNode result = this.search(productData);

        if (result != null) {

            result.getInfo().setPrice(Price);
            System.out.println("Price updated");

        } else {

            System.out.println("Product not found in stock");
        }

    }

    public void productStock(String productId, int stock) {

        Product productData = new Product(productId);
        LinkedListNode result = this.search(productData);

        if (result != null) {

            result.getInfo().setProductStock(stock);
            System.out.println("Product stock updated");

        } else {

            System.out.println("Product not found in stock");
        }

    }

    // Metodo de buscar linear simples
    private LinkedListNode search(Product productData) {

        LinkedListNode aux = this.first;

        if (this.isEmpty()) {

            return null;

        }

        while (aux != null) {

            if (aux.getInfo().compareTo(productData) == 0) {
                return aux;

            }
            aux = aux.getNext();

        }

        return null;

    }

    public void removeByKey(String productId) {

        LinkedListNode aux = this.first;
        Product productData = new Product(productId);

        if (this.isEmpty()) {

            System.out.println("List it's empty!");

        } else if (productData.compareTo(this.first.getInfo()) == 0) {

            this.first = aux.getNext();
            System.out.println("Product: " + productId + " found and deleted");

        } else {

            LinkedListNode prevLast = null;

            while (aux != null && productData.compareTo(aux.getInfo()) != 0) {

                prevLast = aux;
                aux = aux.getNext();

            }

            if (aux != null) {

                prevLast.setNext(aux.getNext());
                System.out.println("Product: " + productId + " found and deleted");

            } else {

                System.out.println("Product: " + productId + " not found");

            }

        }
    }

    public void removeRepeated(String productId) {

        LinkedListNode aux = this.first;
        int counter = 0;

        if (this.isEmpty()) {

            System.out.println("List it's empty!");

        } else {

            LinkedListNode prevLast = null;
            Product productData = new Product(productId);

            while (aux != null && productData.compareTo(this.first.getInfo()) == 0) {

                this.first = this.first.getNext();
                counter++;

                prevLast = aux;
                aux = aux.getNext();

            }

            while (aux != null) {

                if (productData.compareTo(aux.getInfo()) != 0) {

                    prevLast = aux;
                    aux = aux.getNext();

                } else {

                    prevLast.setNext(aux.getNext());
                    counter++;
                    aux = aux.getNext();

                    System.out.println("Product: " + productId + " found and deleted");
                }

            }

            if (counter != 0) {
                System.out.println("contador: " + counter);

            } else {
                System.out.println(productId + " id not found on stock");

            }

        }

    }

}
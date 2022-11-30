package Facade;
import ADT.DoublyLinkedList;
import ADT.DoublyNode;
import interfaces.Client;

public class ClienteDataBase {

    private DoublyLinkedList<Client> clientData;

    public ClienteDataBase() {

        this.clientData = new DoublyLinkedList<>();

    }


    public void registerClient(Client data) {

        this.clientData.insertCrescentOrder(data);
    }


    public void showClientRoster() {

        this.clientData.showData();
    }

    public Client getClient(String id) {
        Client clientId = new Client(id);
        DoublyNode<Client> result = clientData.search(clientId);

        if (result != null) {

            return result.getInfo();
        }

        return null;
    }

    public void showClientInfo(String id) {

        Client clientId = new Client(id);
        DoublyNode<Client> result = clientData.search(clientId);

        if (result != null) {

            System.out.println(result.getInfo());

        } else {

            System.out.println("Client not found");
        }
    }

    public void setNewPassword(String id, String password) {

        Client clientId = new Client(id);
        DoublyNode<Client> result = clientData.search(clientId);

        if (result != null) {

            result.getInfo().setPassword(password);
            System.out.println("New password stored");

        } else {

            System.out.println("Client not found");
        }

    }

    public boolean passwordCheck(String id, String password) {

        Client clientId = new Client(id);
        DoublyNode<Client> result = clientData.search(clientId);

        if (result != null) {

            return result.getInfo().passwordCheck(password);
            
        }

        return false;
            
    }




    
    
}

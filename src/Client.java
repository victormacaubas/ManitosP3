public class Client extends Person implements Comparable<Client>{

    private String password;

    public boolean passwordCheck(String data) {

        if (this.password.equalsIgnoreCase(data)) {
            return true;
        }

        return false;
    }

    public Client(String id, String name) {
        super(id, name);
    }

    public void setPassword(String data) {
        this.password = data;
    }

    @Override
    public String toString() {
        return "Client ID: " + this.getId() + "Username: " + this.getName();
    }

    @Override
    public int compareTo(Client data) {
        int result;

        result = this.getId().compareToIgnoreCase(data.getId());

        return result;
    }
}

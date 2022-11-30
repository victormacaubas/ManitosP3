public class Client extends Person implements Comparable<Client>{

    private String password;

    public boolean passwordCheck(String data) {

        if (this.password.equals(data)) {
            return true;
        }

        return false;
    }

    public Client(String id, String name, String password) {
        super(id,name);
    }

    public Client(String id) {
        super(id);
    }

    public void setPassword(String data) {
        this.password = data;
    }


        public String getPassword() {
        return password;
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

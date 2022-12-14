package interfaces;
abstract class Person {

    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String id) {
        this.id = id;
    }

    public abstract String toString();

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

}

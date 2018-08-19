import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String name;
    protected int weight;

    public Animal () {
        name = "";
        weight = 0;
    }

    public Animal (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void sleep () {
        System.out.println ("The animal is sleeping.");
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return "Name: " + name + " Weight: " + weight;
    }
}
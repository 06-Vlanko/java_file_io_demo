import java.util.ArrayList;
import java.util.List;

public class FileTestRunner {

    public static void main (String [] args) {
        // UtfTest test = new UtfTest();
        // UtfTest test2 = new UtfTest();
        // String[] str = {"abc", "   ", "123 def", "yyyy", "llll   "};

        // test.writeToFile(str);
        // System.out.println ("FILE WAS JUST WRITTEN ------");
        // test.readFile();
        // test.updateFile("yyyy", "mmmm");
        // System.out.println ("FILE WAS JUST UPDATED ------");
        // test2.readFile();
        Animal gato = new Cat("Misifus", 5);
        Animal perro = new Dog("Pietro", 20);

        System.out.println ("GATO CLASS: " + gato.getClass());

        FileManipulator manipulator = new FileManipulator ("test.dat");
        
        manipulator.writeFile(gato);
        manipulator.writeFile(perro);

        List<Animal> animalList = manipulator.readFile();
        
        for (Animal animal : animalList) {
            if (animal.getName().equals(gato.getName())) {
                System.out.println ("This is object gato");
            } 
            animal.sleep();
        }
    }
}
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {


    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    private FileOutputStream out;
    private String fileName;

    public FileManipulator (String fileName) {
        this.fileName = fileName;
    }

    public boolean writeFile (Animal animal) {
        try {
        startWriter();
        writer.writeObject(animal);

        writer.close();
        out.close();
        } catch (IOException e) {
            System.out.println (e.getMessage());
            return false;
        }
        return true;
    }

    public List<Animal> readFile () {
        
        List<Animal> animalList = new ArrayList<Animal>();
        boolean cont = true;
        try {
            ObjectInputStream reader = new ObjectInputStream (new FileInputStream (fileName));
            while (cont){
                Animal animal = null;
                try {
                    animal = (Animal) reader.readObject();
                } catch (ClassNotFoundException e) {
                    System.out.println ("Unable tor read Object from file " + e.getMessage());
                }
                if (animal != null)
                    animalList.add(animal);
                else
                    cont = false;
                }
        } catch (FileNotFoundException e) {
            System.out.println ("Unable to find file \"" + fileName + "\"" + e.getMessage());
        } catch (IOException e) {
            System.out.println (e.getMessage());
        }
        return animalList;
    }

    private void startWriter () {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                out = new FileOutputStream(fileName);
                writer = new ObjectOutputStream (out);
            } catch (IOException e) {
                System.out.println("Unable to initialize reader" + e.getMessage());
            }
        } else {
            try {
                out = new FileOutputStream(fileName, true);
                writer = new AppendableObjectOutputStream(out);
            } catch (IOException e) {
                System.out.println("Unable to initialize reader" + e.getMessage());
            }
        }
    }
}
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.FileNotFoundException;

public class UtfTest {

    public void writeToFile(String[] str) {
        FileOutputStream fileOut = null;
        DataOutputStream out = null;
        try {
            fileOut = new FileOutputStream("utf_test.dat", true);
            out = new DataOutputStream(fileOut);
            for (String element : str) {
                out.writeUTF(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
                out.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void readFile() {
        FileInputStream fileIn = null;
        DataInputStream in = null;
        
        try {
            fileIn = new FileInputStream("utf_test.dat");
            in = new DataInputStream(fileIn);

            String temp = "";

            while (in.available() > 0) {
                temp = in.readUTF();
                System.out.println("String: " + temp + "|");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileIn.close();
                in.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateFile (String searchMe, String newValue) {
        DataInputStream in = null;
        DataOutputStream out = null;
        String temp = null;

        try {
            in = new DataInputStream(new FileInputStream("utf_test.dat"));
            out = new DataOutputStream(new FileOutputStream("utf_test.dat"));
            while (true) {
                temp = in.readUTF();
                System.out.println ("CURRENT TEMP VALUE: " + temp);
                if (temp.equals(searchMe)) {
                    out.writeUTF(newValue);
                }
            }
        } catch (Exception e) {
            System.out.println (e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
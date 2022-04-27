package Life;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class lifeFile implements Serializable {
    JFileChooser jfc;
    JButton jfcB;
    lifeBoard lifeBoard;
    static int[][] grid;

    static int[][] write(String fileName)
            throws IOException {

        FileOutputStream fos = new FileOutputStream("filename.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(grid);
        oos.close();
        return grid;

    }

    // private void readObject(ObjectInputStream ois)
    // throws IOException, ClassNotFoundException {
    // ois.defaultReadObject();

    // }

    static int[][] read(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int[][] grid = (int[][]) ois.readObject();

            ois.close();
            return grid;

        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e);
            return null;
        }

    }
}

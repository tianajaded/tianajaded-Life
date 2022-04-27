package Life;

import java.awt.event.ActionEvent;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;

import javax.jfc.setDialogType;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class lifeFile implements Serializable, ActionListener {
    JFileChooser jfc;
    JButton jfcB;

    public lifeFile() {
        jfcB = new JButton("Select File");

        jfcB.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jfcB) {

                    // File gameState = lifeBoard.getState();
                    JFileChooser jfc = new JFileChooser();
                    jfc.setCurrentDirectory(new File("."));
                    jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    setDialogType txtfilter = new javax.jfc.setDialogType();

                    int result = jfc.showSaveDialog(null);

                    if (result == jfc.APPROVE_OPTION) {
                        String fileName = jfc.getName();
                        if (!fileName.contains(".")) {
                            fileName += ".txt";
                        }
                        lifePrint lifePrint = new lifePrint();
                        String str = lifePrint.toString();
                        write(str, fileName);
                    }
                }
            }
        });
    }

    static void write(String file, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(file);
            oos.close();
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        }
    }

    static int[][] read() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        File selectedFile = null;
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }

        if (selectedFile != null) {
            try {
                FileInputStream fis = new FileInputStream(selectedFile);
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
        return null;

    }

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

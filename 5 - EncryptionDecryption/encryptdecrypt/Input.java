package encryptdecrypt;

import java.io.*;
import java.util.*;

public class Input {
    private String alg;
    private String mode;
    private String data;
    private int key;

    public Input() {
        this.alg = "shift";
        this.mode = "enc";
        this.data = "";
        this.key = 0;
    }

    public String getAlg() {
        return alg;
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    void setMode(String mode) {
        this.mode = mode;
    }

    void setData(String data) {
        this.data = data;
    }

    void setKey(int key) {
        this.key = key;
    }

    public void takeInput(String[] args) {
        String outPath = "";
        File file;
        PrintWriter pw;

        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("-mode")) {
                setMode(args[i + 1]);
            }
            if (args[i].equals("-key")) {
                setKey(Integer.parseInt(args[i + 1]));
            }
            if (args[i].equals("-data")) {
                setData(args[i + 1]);
            }
            if (args[i].equals("-in") && getData().equals("")) {
                try {
                    setData(takeDataFromFile(args[i + 1]));
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                    System.exit(1);
                }
            }
            if (args[i].equals("-out")) {
                outPath = args[i + 1];
            }
        }
    }

    static String takeDataFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner reader = new Scanner(file);
        return reader.nextLine();
    }
}

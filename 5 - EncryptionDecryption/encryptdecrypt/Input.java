package encryptdecrypt;

import java.io.*;
import java.util.*;

public class Input {
    private String alg;
    private String mode;
    private String data;
    private int key;
    private String toFile;

    public Input() {
        this.alg = "shift";
        this.mode = "enc";
        this.data = "";
        this.key = 0;
        this.toFile = null;
    }

    public void takeInput(String[] args) {

        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("-alg")) {
                this.alg = args[i + 1];
            }
            if (args[i].equals("-mode")) {
                this.mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                try {
                    this.key = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException ee) {
                    this.key = 0;
                }
            }
            if (args[i].equals("-data")) {
                this.data = args[i + 1];
            }
            if (args[i].equals("-in") && this.data.equals("")) {
                try {
                    this.data = takeDataFromFile(args[i + 1]);
                } catch (FileNotFoundException e) {
                    System.out.println("Error while reading from file");
                    this.data = "";
                }
            }
            if (args[i].equals("-out")) {
                this.toFile = args[i + 1];
            }
        }
    }

    public String convertData() {
        Converter converter;
        if ("unicode".equals(this.alg)) {
            converter = new UnicodeConverter();
        } else {
            converter = new ShiftConverter();
        }
        return converter.convert(this.mode, this.data, this.key);
    }

    public void printOutput(String data) {
        File file;
        PrintWriter pw;

        if (this.toFile == null) {
            System.out.println(data);
        } else {
            file = new File(this.toFile);
            try {
                pw = new PrintWriter(file);
                pw.println(data);
                pw.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error while writing to file");
                System.out.println(data);
            }
        }
    }

    static String takeDataFromFile(String path) throws FileNotFoundException {
        String data;
        File file = new File(path);
        Scanner reader = new Scanner(file);
        data = reader.nextLine();
        reader.close();
        return data;
    }
}

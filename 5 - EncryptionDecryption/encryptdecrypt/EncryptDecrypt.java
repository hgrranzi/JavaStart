package encryptdecrypt;
import java.io.*;
import java.util.*;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String outPath = "";
        File file;
        PrintWriter pw;

        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("-mode")) {
                converter.setMode(args[i + 1]);
            }
            if (args[i].equals("-key")) {
                converter.setKey(Integer.parseInt(args[i + 1]));
            }
            if (args[i].equals("-data")) {
                converter.setData(args[i + 1]);
            }
            if (args[i].equals("-in") && converter.getData().equals("")) {
                try {
                    converter.setData(takeDataFromFile(args[i + 1]));
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                    System.exit(1);
                }
            }
            if (args[i].equals("-out")) {
               outPath = args[i + 1];
            }
        }
       if (outPath.equals("")) {
            System.out.println(converter.convert());
       } else {
            file = new File(outPath);
            try {
                pw = new PrintWriter(file);
                pw.println(converter.convert());
                pw.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error");
                System.exit(1);
            }
       }
    }

    static String takeDataFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner reader = new Scanner(file);
        return reader.nextLine();
    }
}

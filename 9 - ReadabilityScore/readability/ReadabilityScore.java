package readability;

import java.io.*;

public class ReadabilityScore {
    public static void main(String[] args) {

       if (args.length == 1) {
           try {
               BufferedReader inReader = new BufferedReader(new FileReader(args[0]));
               HardChecker.hardScore(inReader);
           } catch (IOException e) {
               System.out.println("Error. Something wrong with the file");
           }
       } else {
           System.out.println("Error. Something wrong with arguments");
       }
    }
}
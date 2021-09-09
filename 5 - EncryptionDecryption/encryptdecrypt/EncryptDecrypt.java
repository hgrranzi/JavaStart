package encryptdecrypt;
import java.util.*;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        String option = term.nextLine();
        String message = term.nextLine();
        int key = term.nextInt();

        if ("enc".equals(option)) {
            System.out.println(encryptShift(message, key));
        } else if ("dec".equals(option)) {
            System.out.println(decryptShift(message, key));
        }
    }

    static char[] encryptShift(String text, int key) {
        char[] encryptedText;

        encryptedText = new char[text.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (char) (text.charAt(i) + key);
            //if (encryptedText[i] > 122) {
            //    encryptedText[i] = (char) (96 + (encryptedText[i] - 122));
            //}
        }
        return encryptedText;
    }

    static char[] decryptShift(String text, int key) {
        char[] encryptedText;

        encryptedText = new char[text.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (char) (text.charAt(i) - key);
            //if (encryptedText[i] < 97) {
             //   encryptedText[i] = (char) (123 - (97 - encryptedText[i]));
            //}
        }
        return encryptedText;
    }
}

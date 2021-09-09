package encryptdecrypt;
import java.util.*;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        String message = term.nextLine();
        int key = term.nextInt();

        System.out.println(encryptShift(message, key));
    }

    static char[] encryptShift(String text, int key) {
        char[] encryptedText;

        encryptedText = new char[text.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = encryptChar(text.charAt(i), key);
        }
        return  encryptedText;
    }

    static char encryptChar(char c, int key) {
        char res = c;
        if (Character.isAlphabetic(res)) {
            res += key;
            if (res > 122) {
                res = (char) (96 + (res - 122));
            }
        }
        return res;
    }
}
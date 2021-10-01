package encryptdecrypt;

import java.util.Arrays;

public interface Converter {

    public default String convert(Input input) {
        if ("dec".equals(input.getMode())) {
            return encrypt(input.getData(), input.getKey());
        }
        return decrypt(input.getData(), input.getKey());
    }

    public abstract String encrypt(String data, int key);

    public abstract String decrypt(String data, int key);
}

class ShiftConverter implements Converter {
    @Override
    public String encrypt(String data, int key) {
        return null;
    }

    @Override
    public String decrypt(String data, int key) {
        return null;
    }
}

class UnicodeConverter implements Converter {
    @Override
    public String encrypt(String data, int key) {
        char[] encryptedText;

        encryptedText = new char[data.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (char) (data.charAt(i) + key);
        }
        return Arrays.toString(encryptedText);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] decryptedText;

        decryptedText = new char[data.length()];
        for (int i = 0; i < decryptedText.length; i++) {
            decryptedText[i] = (char) (data.charAt(i) - key);
        }
        return Arrays.toString(decryptedText);
    }
}
package encryptdecrypt;

public interface Converter {

    default String convert(String mode, String data, int key) {
        if ("dec".equals(mode)) {
            return decrypt(data, key);
        }
        return encrypt(data, key);
    }

    String encrypt(String data, int key);

    String decrypt(String data, int key);
}

class ShiftConverter implements Converter {
    @Override
    public String encrypt(String data, int key) {
        char[] encryptedText;

        encryptedText = new char[data.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = encryptChar(data.charAt(i), key);
        }
        return String.valueOf(encryptedText);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] decryptedText;

        decryptedText = new char[data.length()];
        for (int i = 0; i < decryptedText.length; i++) {
            decryptedText[i] = decryptChar(data.charAt(i), key);
        }
        return String.valueOf(decryptedText);
    }

    static char encryptChar(char c, int key) {
        char res = c;
        if (Character.isAlphabetic(res)) {
            res += key;
            if (Character.isLowerCase(c)) {
                if (res > 122) {
                    res = (char) (96 + (res - 122));
                }
            } else {
                if (res > 90) {
                    res = (char) (64 + (res - 90));
                }
            }
        }
        return res;
    }

    static char decryptChar(char c, int key) {
        char res = c;
        if (Character.isAlphabetic(res)) {
            res -= key;
            if(Character.isLowerCase(c)) {
                if (res < 97) {
                    res = (char) (123 - (97 - res));
                }
            } else {
                if (res < 65) {
                    res = (char) (91 - (65 - res));
                }
            }
        }
        return res;
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
        return String.valueOf(encryptedText);
    }

    @Override
    public String decrypt(String data, int key) {
        char[] decryptedText;

        decryptedText = new char[data.length()];
        for (int i = 0; i < decryptedText.length; i++) {
            decryptedText[i] = (char) (data.charAt(i) - key);
        }
        return String.valueOf(decryptedText);
    }
}
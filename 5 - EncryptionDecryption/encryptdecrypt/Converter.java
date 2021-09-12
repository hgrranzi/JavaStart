package encryptdecrypt;

public class Converter {
    private String mode;
    private String data;
    private int key;

    public Converter() {
        this.mode = "enc";
        this.data = "";
        this.key = 0;
    }

    String getData() {
        return this.data;
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

    char[] convert() {
        if ("dec".equals(this.mode)) {
             return decryptShift();
        }
        return encryptShift();
    }

    char[] encryptShift() {
        char[] encryptedText;

        encryptedText = new char[this.data.length()];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (char) (this.data.charAt(i) + this.key);
        }
        return encryptedText;
    }

    char[] decryptShift() {
        char[] decryptedText;

        decryptedText = new char[this.data.length()];
        for (int i = 0; i < decryptedText.length; i++) {
            decryptedText[i] = (char) (this.data.charAt(i) - this.key);
        }
        return decryptedText;
    }
}
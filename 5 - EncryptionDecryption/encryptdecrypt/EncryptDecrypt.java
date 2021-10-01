package encryptdecrypt;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Input input = new Input();
        if (args.length % 2 == 0) {
            input.takeInput(args);
            input.printOutput(input.convertData());
        } else {
            System.out.println("Error while taking arguments");
        }
    }

}
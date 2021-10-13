import java.util.*;

public class NumberBaseConverter {
    static char[] digits = "01234567890ABCDF".toCharArray();

    public static void main(String[] args) {
        Input mode = null;

        while (mode != Input.EXIT) {
            try {
                mode = Input.takeInput();
                convert(mode);
            } catch (IllegalArgumentException e) {
                System.out.println("invalid input, try again.");
            }
        }
    }

    public static void convert(Input mode) {

        if (mode == Input.FROM) {
            fromDecimal();
        } else if (mode == Input.TO) {
            toDecimal();
        }
    }

    public static void fromDecimal() {
        int number;
        int base;
        Scanner term = new Scanner(System.in);

        System.out.print("Enter number in decimal system: ");
        number = term.nextInt();
        System.out.print("Enter target base: ");
        base = term.nextInt();
        System.out.println("Conversion result: " + Integer.toString(number, base));
    }

    public static void toDecimal() {
        String number;
        int base;
        Scanner term = new Scanner(System.in);

        System.out.print("Enter source number: ");
        number = term.nextLine();
        System.out.print("Enter source base: ");
        base = term.nextInt();
        System.out.println("Conversion to decimal result: " + Integer.parseInt(number, base));
    }
}
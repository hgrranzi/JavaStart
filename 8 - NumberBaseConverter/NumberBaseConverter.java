import java.util.*;

public class NumberBaseConverter {
    static char[] digits = "01234567890ABCDF".toCharArray();

    public static void main(String[] args) {
        int number;
        int base;
        Scanner term = new Scanner(System.in);

        System.out.print("Enter number in decimal system: ");
        number = term.nextInt();
        System.out.print("Enter target base: ");
        base = term.nextInt();
        System.out.println("Conversion result: " + Integer.toString(number, base));
    }

}
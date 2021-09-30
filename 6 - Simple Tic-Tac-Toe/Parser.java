import java.util.*;

public class Parser {
    public static String takeInput() {
        Scanner term = new Scanner(System.in);
        System.out.print("Enter cells: ");
        return term.nextLine();
    }

    public static boolean isValid(String input) {
        if (input.length() != 9) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '_' && input.charAt(i) != 'O' && input.charAt(i) != 'X') {
                return false;
            }
        }
        return true;
    }
}
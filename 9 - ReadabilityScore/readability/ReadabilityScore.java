package readability;

import java.util.Scanner;

public class ReadabilityScore {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        String text = term.nextLine();

        if (text.length() > 100) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
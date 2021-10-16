package readability;

import java.util.Scanner;

public class ReadabilityScore {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        String text = term.nextLine().replaceAll("^\\s+$\\s+", "");

        if (HardChecker.isHard(text)) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
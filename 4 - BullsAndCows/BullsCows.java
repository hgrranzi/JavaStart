import java.util.*;

import java.util.*;

public class BullsCows {
    public static void main(String[] args) {
        int n = 9305;
        Scanner term = new Scanner(System.in);
        BullsCowsCount bc = new BullsCowsCount();
        char[] guess = term.nextLine().toCharArray();
        char[] number = String.valueOf(n).toCharArray();

        bc.countBullsCows(number, guess);
        printGrade(bc.getBulls(), bc.getCows(), n);
    }

    public static void printGrade(int bulls, int cows, int number) {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). ", bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). ", bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s). ", cows);
        } else {
            System.out.print("Grade: None. ");
        }
        System.out.printf("The secret code is %d\n", number);
    }
}
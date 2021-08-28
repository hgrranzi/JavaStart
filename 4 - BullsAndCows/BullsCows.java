import java.util.*;

import java.util.*;

public class BullsCows {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        BullsCowsCount bc = new BullsCowsCount();
        int len;
        int n;

        len = term.nextInt();
        if (len > 0 && len <= 10) {
            n = generateNumber(len);
            System.out.printf("The random secret number is %d.\n", n);
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", len);
        }
        //char[] guess = term.nextLine().toCharArray();
        //char[] number = String.valueOf(n).toCharArray();

        //bc.countBullsCows(number, guess);
        //printGrade(bc.getBulls(), bc.getCows(), n);
    }

    public static int generateNumber(int len) {
        Random generator = new Random();
        int min = (int) Math.pow(10, (len - 1));
        int max = (int) Math.pow(10, len) - 1;
        int interval = max - min;
        int number;

        do {
            number = generator.nextInt(interval + 1) + min;
        } while (!uniqueDigits(number));
        return number;
    }

    public static boolean uniqueDigits(int number) {
        char[] arr = String.valueOf(number).toCharArray();
        int[] digits = new int[10];

        for (char i : arr) {
            digits[i - 48]++;
            if (digits[i - 48] > 1) {
                return false;
            }
        }
        return true;
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
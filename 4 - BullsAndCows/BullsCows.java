import java.util.*;

public class BullsCows {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        BullsCowsCount bc;
        int len;
        int n;
        char[] number;
        char[] guess;
        int turn;

        System.out.println("Please, enter the secret code's length:");
        len = term.nextInt();
        if (len > 0 && len <= 10) {
            System.out.println("Okay, let's start a game!");
            n = generateNumber(len);
            number = String.valueOf(n).toCharArray();
            bc = new BullsCowsCount();
            turn = 1;
            while (bc.getBulls() != number.length) {
                bc.zero();
                System.out.printf("Turn %d:\n", turn);
                guess = term.next().toCharArray();
                bc.countBullsCows(number, guess);
                printGrade(bc.getBulls(), bc.getCows());
                turn++;
            }
            System.out.println("Congratulations! You guessed the secret code.");
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", len);
        }
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

    public static void printGrade(int bulls, int cows) {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). ", bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). ", bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s). ", cows);
        } else {
            System.out.print("Grade: None. ");
        }
        System.out.println();
    }
}
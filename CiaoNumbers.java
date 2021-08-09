package numbers;
import java.util.Scanner;

public class CiaoNumbers {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        long request;
        boolean ok = true;
        welcomeMessage();
        while (ok) {
            System.out.print("Enter a request:");
            System.out.println("");
            request = term.nextLong();
            ok = checkRequest(request);
        }
        System.out.println("Goodbye!");
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println("");
    }

    public static boolean checkRequest(long n) {
        boolean even = false;
        boolean odd = false;
        boolean buzz = false;
        boolean duck = false;
        boolean pal = false;
        if (n == 0) {
            return false;
        } else if (n < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        } else {
            if (n % 2 == 0) {
                even = true;
            } else {
                odd = true;
            }
            buzz = checkBuzz(n);
            duck = checkDuck(n);
            pal = checkPal(n);
        }
        printRes(n, even, odd, buzz, duck, pal);
        return true;
    }

    public static boolean checkBuzz(long n) {
        boolean buzz = false;
        if (n == 7 || ((n / 10 - (n % 10) * 2) % 7 == 0)) {
            if (n % 10 == 7) {
                buzz = true;
            } else {
                buzz = true;
            }
        } else if (n % 10 == 7) {
            buzz = true;
        } else {
            buzz = false;
        }
        return buzz;
    }

    public static boolean checkDuck(long n) {
        boolean duck = false;
        for (long tmp = n; tmp > 0; tmp /= 10) {
            if (tmp % 10 == 0)
                duck = true;
        }
        return duck;
    }

    public static boolean checkPal(long n) {
        boolean pal = true;
        String nn = Long.toString(n);
        int last = nn.length() - 1;
        int i = 0;
        while (i <= last) {
            if (nn.charAt(i) != nn.charAt(last)) {
                pal = false;
                break;
            }
            i++;
            last--;
        }
        return pal;
    }

    public static void printRes(long n, boolean even, boolean odd, boolean buzz, boolean duck, boolean pal) {
        System.out.println("Properties of " + n);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + pal);
        System.out.println("");
    }
}
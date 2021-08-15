import java.util.Scanner;

public class AmazingNumbers {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        String input;
        String[] request;
        boolean ok = true;
        welcomeMessage();
        while (ok) {
            System.out.print("Enter a request:");
            System.out.println();
            input = term.nextLine();
            request = input.split(" ");
            ok = checkRequest(request);
        }
        System.out.println("Goodbye!");
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("Enter a natural number to know its properties;");
        System.out.println("Enter two natural numbers to obtain the properties of the list:");
        System.out.println(" - the first parameter represents a starting number;");
        System.out.println(" - the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("Enter 0 to exit.");
        System.out.println();
    }

    public static boolean checkRequest(String[] request) {
        long n = Long.parseLong(request[0], 10);
        long m;

        if (request.length == 2) {
            m = Long.parseLong(request[1], 10);
            return checkList(n, m);
        } else if (n != 0) {
            return checkNumber(n);
        }
        return false;
    }

    public static boolean checkNumber(long n) {
        boolean even = false;
        boolean odd = false;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;

        if (n < 0) {
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
            gapful = checkGapful(n);
        }
        printRes(n, even, odd, buzz, duck, pal, gapful);
        return true;
    }

    public static boolean checkList(long n, long m) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        long i = 0;

        if (n < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (m < 0) {
            System.out.println("The second parameter should be a natural number or zero.");
            return true;
        }
        while (i < m) {
            even = n % 2 == 0;
            buzz = checkBuzz(n);
            duck = checkDuck(n);
            pal = checkPal(n);
            gapful = checkGapful(n);
            printResOfListMember(n, even, buzz, duck, pal, gapful);
            n++;
            i++;
        }
        System.out.println();
        return true;
    }

    public static boolean checkBuzz(long n) {
        boolean buzz;
        if (n == 7 || ((n / 10 - (n % 10) * 2) % 7 == 0)) {
            buzz = true;
        } else buzz = n % 10 == 7;
        return buzz;
    }

    public static boolean checkDuck(long n) {
        boolean duck = false;
        for (long tmp = n; tmp > 0; tmp /= 10) {
            if (tmp % 10 == 0) {
                duck = true;
                break;
            }
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

    public static boolean checkGapful(long n) {
        boolean gapful = true;
        String nn = Long.toString(n);
        long concat;
        if (nn.length() < 3) {
            gapful = false;
        } else {
            concat = (long) (nn.charAt(0) - 48) * 10 + nn.charAt(nn.length() - 1) - 48;
            if (n % concat != 0) {
                gapful = false;
            }
        }
        return gapful;
    }

    public static void printRes(long n, boolean even, boolean odd, boolean buzz, boolean duck, boolean pal, boolean gapful) {
        System.out.println("Properties of " + n);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + pal);
        System.out.println("gapful: " + gapful);
        System.out.println();
    }

    public static void printResOfListMember(long n, boolean even, boolean buzz, boolean duck, boolean pal, boolean gapful) {
        String str = n + " is ";
        if (even) {
            str = str + "even";
        } else {
            str = str + "odd";
        }
        if (buzz) {
            str = str + ", buzz";
        }
        if (duck) {
            str = str + ", duck";
        }
        if (pal) {
            str = str + ", palindromic";
        }
        if (gapful) {
            str = str + ", gapful";
        }
        System.out.println(str);
    }
}

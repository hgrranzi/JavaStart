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
        System.out.println("Enter two natural numbers and a property to search for;");
        System.out.println("Enter 0 to exit.");
        System.out.println();
    }

    public static boolean checkRequest(String[] request) {
        long n = Long.parseLong(request[0], 10);
        long m;
        StringBuilder property;
        if (request.length == 3) {
            m = Long.parseLong(request[1], 10);
            property = new StringBuilder(request[2]);
            return checkProperty(n, m, property);
        }
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
        boolean spy;

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
            spy = checkSpy(n);
        }
        printRes(n, even, odd, buzz, duck, pal, gapful, spy);
        return true;
    }

    public static boolean checkList(long n, long m) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        boolean spy;
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
            spy = checkSpy(n);
            System.out.println(propertyOfListMember(n, even, buzz, duck, pal, gapful, spy));
            n++;
            i++;
        }
        System.out.println();
        return true;
    }

    public static boolean checkProperty(long n, long m, StringBuilder property) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        boolean spy;
        long i = 0;
        StringBuilder str;
        String prop = property.toString().toLowerCase();
        property = new StringBuilder(prop);
        if (n < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (m < 0) {
            System.out.println("The second parameter should be a natural number or zero.");
            return true;
        }
        if (!validProperty(property)) {
            str = new StringBuilder("The property [] is wrong.");
            str.insert(14, property.toString().toUpperCase());
            System.out.println(str);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
            return true;
        }
        while (i < m) {
            even = n % 2 == 0;
            buzz = checkBuzz(n);
            duck = checkDuck(n);
            pal = checkPal(n);
            gapful = checkGapful(n);
            spy = checkSpy(n);
            str = propertyOfListMember(n, even, buzz, duck, pal, gapful, spy);
            if (str.toString().contains(property)) {
                System.out.println(str);
                i++;
            }
            n++;
        }
        System.out.println();
        return true;
    }

    public static boolean validProperty(StringBuilder property) {
        String prop = property.toString();
        return "even".equals(prop) || "odd".equals(prop) || "buzz".equals(prop) || "duck".equals(prop) || "palindromic".equals(prop) || "gapful".equals(prop) || "spy".equals(prop);
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

    public static boolean checkSpy(long n) {
        boolean spy;
        long sum = 0;
        long product = 1;
        long tmp = n;
        while (tmp > 0) {
            sum += tmp % 10;
            product *= tmp % 10;
            tmp = tmp / 10;
        }
        spy = sum == product;
        return spy;
    }

    public static void printRes(long n, boolean even, boolean odd, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy) {
        System.out.println("Properties of " + n);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + pal);
        System.out.println("gapful: " + gapful);
        System.out.println("spy: " + spy);
        System.out.println();
    }

    public static StringBuilder propertyOfListMember(long n, boolean even, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy) {
        StringBuilder str = new StringBuilder(n + " is ");
        if (even) {
            str.append("even");
        } else {
            str.append("odd");
        }
        if (buzz) {
            str.append(", buzz");
        }
        if (duck) {
            str.append(", duck");
        }
        if (pal) {
            str.append(", palindromic");
        }
        if (gapful) {
            str.append(", gapful");
        }
        if (spy) {
            str.append(", spy");
        }
        return str;
    }
}

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
        System.out.println("Enter two natural numbers and two properties to search for;");
        System.out.println("Enter 0 to exit.");
        System.out.println();
    }

    public static boolean checkRequest(String[] request) {
        long n = Long.parseLong(request[0], 10);
        long m;
        StringBuilder property1;
        StringBuilder property2;

        if (request.length == 4) {
            m = Long.parseLong(request[1], 10);
            property1 = new StringBuilder(request[2]);
            property2 = new StringBuilder(request[3]);
            return checkTwoProperties(n, m, property1, property2);
        }
        if (request.length == 3) {
            m = Long.parseLong(request[1], 10);
            property1 = new StringBuilder(request[2]);
            return checkProperty(n, m, property1);
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
        boolean sunny;
        boolean square;
        boolean jumping;

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
            spy = checkSpy(n);
            pal = checkPal(n);
            duck = checkDuck(n);
            gapful = checkGapful(n);
            square = checkSquare(n);
            sunny = checkSunny(n);
            jumping = checkJumping(n);
        }
        printRes(n, even, odd, buzz, duck, pal, gapful, spy, sunny, square, jumping);
        return true;
    }

    public static boolean checkList(long n, long m) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        boolean spy;
        boolean sunny;
        boolean square;
        boolean jumping;
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
            spy = checkSpy(n);
            duck = checkDuck(n);
            pal = checkPal(n);
            gapful = checkGapful(n);
            square = checkSquare(n);
            sunny = checkSunny(n);
            jumping = checkJumping(n);
            System.out.println(propertyOfListMember(n, even, buzz, duck, pal, gapful, spy, sunny, square, jumping));
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
        boolean sunny;
        boolean square;
        boolean jumping;
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
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE, JUMPING]");
            return true;
        }
        while (i < m) {
            even = n % 2 == 0;
            buzz = checkBuzz(n);
            spy = checkSpy(n);
            duck = checkDuck(n);
            pal = checkPal(n);
            gapful = checkGapful(n);
            square = checkSquare(n);
            sunny = checkSunny(n);
            jumping = checkJumping(n);
            str = propertyOfListMember(n, even, buzz, duck, pal, gapful, spy, sunny, square, jumping);
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
        return "even".equals(prop) || "odd".equals(prop) || "buzz".equals(prop) || "duck".equals(prop) ||
                "palindromic".equals(prop) || "gapful".equals(prop) || "spy".equals(prop) || "sunny".equals(prop) ||
                "square".equals(prop) || "jumping".equals(prop);
    }

    public static boolean checkTwoProperties(long n, long m, StringBuilder property1, StringBuilder property2) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        boolean spy;
        boolean sunny;
        boolean square;
        boolean jumping;
        StringBuilder str;
        String prop1 = property1.toString().toLowerCase();
        String prop2 = property2.toString().toLowerCase();
        property1 = new StringBuilder(prop1);
        property2 = new StringBuilder(prop2);
        long i = 0;

        if (n < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (m < 0) {
            System.out.println("The second parameter should be a natural number or zero.");
            return true;
        }
        if (!validProperty(property1) && !validProperty(property2)) {
            str = new StringBuilder("The properties [] are wrong.");
            str.insert(16, property1.toString().toUpperCase() + ", " + property2.toString().toUpperCase());
            System.out.println(str);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
            return true;
        } else if (!validProperty(property1)) {
            str = new StringBuilder("The property [] is wrong.");
            str.insert(14, property1.toString().toUpperCase());
            System.out.println(str);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
            return true;
        } else if (!validProperty(property2)) {
            str = new StringBuilder("The property [] is wrong.");
            str.insert(14, property2.toString().toUpperCase());
            System.out.println(str);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
            return true;
        }
        if (exclusiveProperties(property1.toString(), property2.toString())) {
            str = new StringBuilder("The request contains mutually exclusive properties: []\nThere are no numbers with these properties.");
            str.insert(54, property1.toString().toUpperCase() + ", " + property2.toString().toUpperCase());
            System.out.println(str);
            return true;
        }
        while (i < m) {
            even = n % 2 == 0;
            buzz = checkBuzz(n);
            spy = checkSpy(n);
            duck = checkDuck(n);
            pal = checkPal(n);
            gapful = checkGapful(n);
            square = checkSquare(n);
            sunny = checkSunny(n);
            jumping = checkJumping(n);
            str = propertyOfListMember(n, even, buzz, duck, pal, gapful, spy, sunny, square, jumping);
            if (str.toString().contains(property1) && str.toString().contains(property2)) {
                System.out.println(str);
                i++;
            }
            n++;
        }
        System.out.println();
        return true;
    }

    public static boolean exclusiveProperties(String property1, String property2) {
        return "even".equals(property1) && "odd".equals(property2) || "even".equals(property2) && "odd".equals(property1)
                || "duck".equals(property1) && "spy".equals(property2) || "spy".equals(property1) && "duck".equals(property2)
                || "square".equals(property1) && "sunny".equals(property2) || "sunny".equals(property1) && "square".equals(property2);
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
    public static boolean checkSunny(long n) {
        long m = n + 1;
        return checkSquare(m);
    }
    public static boolean checkSquare(long n) {
        double doubleSquare = Math.sqrt((double) n);
        long longSquare = (long) Math.sqrt(n);
        return doubleSquare == (double) longSquare || n == 1;
    }

    public static boolean checkJumping(long n) {
        boolean jumping = true;
        long digit = n % 10;
        n = n / 10;
        while (n > 0) {
            if (digit + 1 != n % 10 && digit - 1 != n % 10) {
                jumping = false;
                break;
            }
            digit = n % 10;
            n = n / 10;
        }
        return jumping;
    }

    public static void printRes(long n, boolean even, boolean odd, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy, boolean sunny, boolean square, boolean jumping) {
        System.out.println("Properties of " + n);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + pal);
        System.out.println("gapful: " + gapful);
        System.out.println("spy: " + spy);
        System.out.println("sunny: " + sunny);
        System.out.println("square: " + square);
        System.out.println("jumping: " + jumping);
        System.out.println();
    }

    public static StringBuilder propertyOfListMember(long n, boolean even, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy, boolean sunny, boolean square, boolean jumping) {
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
        if (sunny) {
            str.append(", sunny");
        } else if (square) {
            str.append(", square");
        }
        if (jumping) {
            str.append(", jumping");
        }
        return str;
    }
}

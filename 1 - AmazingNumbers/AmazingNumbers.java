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
        System.out.println("Enter two natural numbers and properties to search for;");
        System.out.println("A property preceded by minus must not be present in numbers;");
        System.out.println("Enter 0 to exit.");
        System.out.println();
    }

    public static boolean checkRequest(String[] request) {
        long n = Long.parseLong(request[0], 10);
        long m;
        int numberOfProperties;
        StringBuilder[] properties;

        if (request.length == 1) {
            if (n != 0) {
                return checkNumber(n);
            }
        }   else {
            m = Long.parseLong(request[1], 10);
            if (request.length == 2) {
                return checkList(n, m);
            } else {
                numberOfProperties = request.length - 2;
                properties = new StringBuilder[numberOfProperties];
                for (int i = 0; i < numberOfProperties; i++) {
                    properties[i] = new StringBuilder(request[i + 2].toUpperCase());
                }
                return checkProperties(n, m, properties);
            }
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
        boolean happy;
        boolean sad = false;

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
            happy = checkHappy(n);
            if (!happy) {
                sad = true;
            }
        }
        printRes(n, even, odd, buzz, duck, pal, gapful, spy, sunny, square, jumping, happy, sad);
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
        boolean happy;
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
            happy = checkHappy(n);
            System.out.println(propertyOfListMember(n, even, buzz, duck, pal, gapful, spy, sunny, square, jumping, happy));
            n++;
            i++;
        }
        System.out.println();
        return true;
    }

    public static boolean validProperty(StringBuilder property) {
        String prop = property.toString();
        return "EVEN".equals(prop) || "ODD".equals(prop) || "BUZZ".equals(prop) || "DUCK".equals(prop) ||
                "PALINDROMIC".equals(prop) || "GAPFUL".equals(prop) || "SPY".equals(prop) || "SUNNY".equals(prop) ||
                "SQUARE".equals(prop) || "JUMPING".equals(prop) || "HAPPY".equals(prop) || "SAD".equals(prop) ||
                "-EVEN".equals(prop) || "-ODD".equals(prop) || "-BUZZ".equals(prop) || "-DUCK".equals(prop) ||
                "-PALINDROMIC".equals(prop) || "-GAPFUL".equals(prop) || "-SPY".equals(prop) || "-SUNNY".equals(prop) ||
                "-SQUARE".equals(prop) || "-JUMPING".equals(prop) || "-HAPPY".equals(prop) || "-SAD".equals(prop);
    }

    public static boolean propertiesAreWrong(StringBuilder[] properties) {
        StringBuilder strError;
        StringBuilder wrongProperties = new StringBuilder("");
        int numberOfWrongProperties = 0;

        for (StringBuilder property : properties) {
            if (!validProperty(property)) {
                if (wrongProperties.length() != 0) {
                    wrongProperties.append(", ");
                }
                wrongProperties.append(property);
                numberOfWrongProperties++;
            }
        }
        if (wrongProperties.length() > 0) {
            if (numberOfWrongProperties > 1) {
                strError = new StringBuilder("The properties [] are wrong.");
                strError.insert(16, wrongProperties.toString());
            } else {
                strError = new StringBuilder("The property [] is wrong.");
                strError.insert(14, wrongProperties.toString());
            }
            System.out.println(strError);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE, JUMPING, HAPPY, SAD]");
            return true;
        }
        return false;
    }

    public static boolean areExclusive(StringBuilder prop1, StringBuilder prop2) {
        if (prop1.toString().equals(prop2.toString())) {
            return false;
        }
        if (!prop1.toString().startsWith("-") && prop2.toString().startsWith("-") && prop1.toString().equals(prop2.toString().substring(1))
        || !prop2.toString().startsWith("-") && prop1.toString().startsWith("-") && prop2.toString().equals(prop1.toString().substring(1))) {
            return true;
        }
        if (prop1.toString().equals("ODD") && prop2.toString().equals("EVEN") || prop1.toString().equals("EVEN") && prop2.toString().equals("ODD")
                || prop1.toString().equals("DUCK") && prop2.toString().equals("SPY") || prop1.toString().equals("SPY") && prop2.toString().equals("DUCK")
                || prop1.toString().equals("SUNNY") && prop2.toString().equals("SQUARE") || prop1.toString().equals("SQUARE") && prop2.toString().equals("SUNNY")
                || prop1.toString().equals("SAD") && prop2.toString().equals("HAPPY") || prop1.toString().equals("HAPPY") && prop2.toString().equals("SAD")) {
            return true;
        }
        if (prop1.toString().equals("-ODD") && prop2.toString().equals("-EVEN") || prop1.toString().equals("-EVEN") && prop2.toString().equals("-ODD")
                || prop1.toString().equals("-DUCK") && prop2.toString().equals("-SPY") || prop1.toString().equals("-SPY") && prop2.toString().equals("-DUCK")
                || prop1.toString().equals("-SAD") && prop2.toString().equals("-HAPPY") || prop1.toString().equals("-HAPPY") && prop2.toString().equals("-SAD")) {
            return true;
        }
        return false;
    }

    public static boolean propertiesAreExclusive(StringBuilder[] properties) {
        StringBuilder str;
        StringBuilder wrongProperties;

        for (int i = 0; i < properties.length; i++) {
            for (int j = i; j < properties.length; j++) {
                if (areExclusive(properties[i], properties[j])) {
                    wrongProperties = new StringBuilder(properties[i] + ", " + properties[j]);
                    str = new StringBuilder("The request contains mutually exclusive properties: []\nThere are no numbers with these properties.");
                    str.insert(53, wrongProperties);
                    System.out.println(str);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasProperties(StringBuilder str, StringBuilder[] properties) {
        for (StringBuilder property : properties) {
            if (!property.toString().startsWith("-") && !str.toString().contains(property.toString().toLowerCase())
                    || property.toString().startsWith("-") && str.toString().contains(property.toString().substring(1).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkProperties(long n, long m, StringBuilder[] properties) {
        boolean even;
        boolean buzz;
        boolean duck;
        boolean pal;
        boolean gapful;
        boolean spy;
        boolean sunny;
        boolean square;
        boolean jumping;
        boolean happy;
        StringBuilder str;
        int i = 0;

        if (n < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (m < 0) {
            System.out.println("The second parameter should be a natural number.");
            return true;
        }
        if (propertiesAreWrong(properties)) {
            return true;
        }
        if (properties.length > 1 && propertiesAreExclusive(properties)) {
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
            happy = checkHappy(n);
            str = propertyOfListMember(n, even, buzz, duck, pal, gapful, spy, sunny, square, jumping, happy);
            if (hasProperties(str, properties)) {
                System.out.println(str);
                i++;
            }
            n++;
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

    public static long sumOfSquares(long n) {
        long sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static boolean checkHappy(long n) {
        for (long number = sumOfSquares(n); number != 1; number = sumOfSquares(number)) {
            if (number > 1 && number <= 4) {
                return false;
            }
        }
        return true;
    }

    public static void printRes(long n, boolean even, boolean odd, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy, boolean sunny, boolean square, boolean jumping, boolean happy, boolean sad) {
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
        System.out.println("happy: " + happy);
        System.out.println("sad: " + sad);
        System.out.println();
    }

    public static StringBuilder propertyOfListMember(long n, boolean even, boolean buzz, boolean duck, boolean pal, boolean gapful, boolean spy, boolean sunny, boolean square, boolean jumping, boolean happy) {
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
        if (happy) {
            str.append(", happy");
        } else {
            str.append(", sad");
        }
        return str;
    }
}

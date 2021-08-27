import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        Machine coffeeMaker = new Machine();
        String action;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = term.nextLine();
            System.out.println();
            if ("buy".equals(action)) {
                buyCoffee(coffeeMaker);
            } else if ("fill".equals(action)) {
                coffeeMaker.fill();
            } else if ("take".equals(action)) {
                coffeeMaker.take();
            } else if ("remaining".equals(action)) {
                coffeeMaker.printState();
            } else if ("exit". equals(action)) {
                break;
            }
            System.out.println();
        }
    }

    public static void buyCoffee(Machine coffeeMaker) {
        Scanner term = new Scanner(System.in);
        String option;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        option = term.nextLine();
        if (!"back".equals(option)) {
            coffeeMaker.make(Integer.parseInt(option) - 1);
        }
    }

    public static void calculateAndPrintIngredients(int cups) {
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", 200 * cups);
        System.out.printf("%d ml of milk\n", 50 * cups);
        System.out.printf("%d g of coffee beans\n", 15 * cups);
    }

    public static void printProcess() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
}
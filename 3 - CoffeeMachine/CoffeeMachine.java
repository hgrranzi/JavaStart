import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        Machine coffeeMaker = new Machine();
        String action;

        coffeeMaker.printState();
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        action = term.nextLine();
        if ("buy".equals(action)) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int option = term.nextInt();
            coffeeMaker.make(option - 1);
        } else if ("fill".equals(action)) {
            coffeeMaker.fill();
        } else if ("take".equals(action)) {
            coffeeMaker.take();
        }
        System.out.println();
        coffeeMaker.printState();
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
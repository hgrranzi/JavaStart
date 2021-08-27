import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        int cups;

        System.out.println("Write how many cups of coffee you will need:");
        cups = term.nextInt();
        calculateAndPrintIngredients(cups);
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
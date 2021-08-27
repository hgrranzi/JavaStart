import java.util.*;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int disposableCups;
    private int money;

    Machine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public void make(int type) {
        CoffeeType coffee = CoffeeType.values()[type];
        if (this.water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < coffee.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.disposableCups--;
            this.water -= coffee.getWater();
            this.milk -= coffee.getMilk();
            this.beans -= coffee.getBeans();
            this.money += coffee.getPrice();
        }
    }

    public void fill() {
        Scanner term = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        this.water += term.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += term.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += term.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += term.nextInt();
    }

    public void take() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }

    public void printState() {
        System.out.printf("The coffee machine has:\n");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.beans);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%d of money\n", this.money);
    }

    /*public void ableToMake(int amount) {
        int ability;

        ability = minFromThree(this.water / waterForCup, this.milk / milkForCup, this.beans / beansForCup);

        if (ability > amount) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", ability - amount);
        } else if (ability == amount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", ability);
        }
    }*/

    public static int minFromThree(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= c && b <= a) {
            return b;
        } else {
            return c;
        }
    }

}
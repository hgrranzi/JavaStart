public class Machine {
    static final int waterForCup = 200;
    static final int milkForCup = 50;
    static final int beansForCup = 15;
    private int water;
    private int milk;
    private int beans;

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void ableToMake(int amount) {
        int ability;

        ability = minFromThree(this.water / waterForCup, this.milk / milkForCup, this.beans / beansForCup);

        if (ability > amount) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", ability - amount);
        } else if (ability == amount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", ability);
        }

    }

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
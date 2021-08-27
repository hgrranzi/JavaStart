public enum CoffeeType {
    ESPRESSO("espresso", 250, 0, 16, 4),
    LATTE("latte", 350, 75, 20, 7),
    CAPPUCINO("cappucino", 200, 100, 12, 6);

    private final String type;
    private  final int water;
    private  final int milk;
    private  final int beans;
    private  final int price;

    CoffeeType(String type, int water, int milk, int beans, int price) {
        this.type = type;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getPrice() {
        return price;
    }
}
package lab5;

public class Resources {
    private int water;
    private int milk;
    private int coffee;
    private double money;

    public Resources(int water, int milk, int coffee, double money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = money;
    }

    public int getWater() { //encapsulation
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public boolean hasEnoughIngredients(Coffee coffeeObject) {
        return water >= coffeeObject.getWater() && milk >= coffeeObject.getMilk() && coffee >= coffeeObject.getCoffee();
    }

    public void make(Coffee coffeeObject) {
        water -= coffeeObject.getWater();
        milk -= coffeeObject.getMilk();
        coffee -= coffeeObject.getCoffee();
    }

    public void addRevenue(double amount) {
        money += amount;
    }

    public void report() {
        System.out.println("Water: " + water + "ml");
        System.out.println("Milk: " + milk + "ml");
        System.out.println("Coffee: " + coffee + "g");
        System.out.println("Money: $" + money);
    }
}
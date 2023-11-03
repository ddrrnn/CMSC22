package lab5;

public abstract class Coffee { //abstraction
    protected String name;
    protected int water;
    protected int milk;
    protected int coffee;
    protected double cost;

    public String getName() {
        return name;
    }
    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }
    public int getCoffee() {
        return coffee;
    }
    public double getPrice() {
        return cost;
    }

    public class Latte extends Coffee { //inheritence
        public Latte() {
            name = "latte";
            water = 200;
            milk = 100;
            coffee = 15;
            cost = 2.25;
        }
    }
    
    public class Espresso extends Coffee {
        public Espresso() {
            name = "espresso";
            water = 150;
            milk = 0;
            coffee = 20;
            cost = 1.5;
        }
    }

    public class Cappuccino extends Coffee {
        public Cappuccino() {
            name = "cappuccino";
            water = 250;
            milk = 75;
            coffee = 18;
            cost = 3.5;
        }
}

}

package lab5;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    private Resources resources;

    public CoffeeMachine() {
        resources = new Resources(500, 500, 500, 0);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean machineOn = true;

        while (machineOn) {

            System.out.println("What type of coffee would you like?");
            System.out.println("===================================");
            System.out.println("Espresso                      $1.50");
            System.out.println("Latte                         $2.25");
            System.out.println("Cappuccino                    $3.50");
            System.out.println("===================================");
            System.out.println("Choice:");
            String choice = scanner.next().toLowerCase();


            switch (choice) {
                case "espresso":
                case "latte":
                case "cappuccino":
                    prepareCoffee(choice);
                    break;
                case "off":
                    machineOn = false;
                    break;
                case "report":
                    resources.report();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void prepareCoffee(String coffeeType) {
        Coffee selectedCoffee; //polymorphism
        switch (coffeeType) {
            case "espresso":
                selectedCoffee = new Espresso();
                break;
            case "latte":
                selectedCoffee = new Latte();
                break;
            case "cappuccino":
                selectedCoffee = new Cappuccino();
                break;
            default:
                return;
        }

        if (resources.hasEnoughIngredients(selectedCoffee)) {
            double cost = selectedCoffee.getPrice();
            double coins = collectCoins();

            if (coins < cost) {
                System.out.println("Sorry, that's not enough money. Money refunded.");
            } else {
                double change = coins - cost;
                resources.addRevenue(cost);
                if (change > 0) {
                    System.out.printf("Here is $%.2f in change.%n", change);
                }
                resources.make(selectedCoffee);
                System.out.println("Here is your " + selectedCoffee.getName() + ". Enjoy your coffee!");
            }
        } else {
            if (resources.getWater() < selectedCoffee.getWater()) {
                System.out.println("Sorry, there is not enough water.");
            } else if (resources.getMilk() < selectedCoffee.getMilk()) {
                System.out.println("Sorry, there is not enough milk.");
            } else if (resources.getCoffee() < selectedCoffee.getCoffee()) {
                System.out.println("Sorry, there are not enough coffee beans.");
        }
    }
    }

    private double collectCoins() {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
    
        String[] coinNames = {"Quarters", "Dimes", "Nickels", "Pennies"};
        double[] coinValues = {0.25, 0.10, 0.05, 0.01};
    
        for (int i = 0; i < coinNames.length; i++) {
            while (true) {
                try {
                    System.out.print(coinNames[i] + ": ");
                    double coin = scanner.nextDouble();
                    if (coin < 0) {
                        throw new InputMismatchException();
                    } else {
                        total += coin * coinValues[i];
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }
    
        return total;
    }
    
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.run();
    }
}

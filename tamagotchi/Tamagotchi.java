public class Tamagotchi {
    private String name;
    private int hungerLevel;
    private int happiness;
    private int trainingLevel;
    private Location currentLocation;

    //initialize Tamagotchi with default values
    public Tamagotchi(String name) {
        this.name = name;
        this.hungerLevel = 50;
        this.happiness = 50;
        this.trainingLevel = 0;
        this.currentLocation = new Lobby();
    }

    //perform an action based on the user's choice
    public void performAction(String choice) {
        currentLocation.performAction(this, choice);
    }

    //display the status
    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Hunger: " + hungerLevel);
        System.out.println("Happiness: " + happiness);
        System.out.println("Training Level: " + trainingLevel);
    }

    //decrease hunger level
    public void decreaseHunger(int amount) {
        if (hungerLevel - amount <= 5) {
            hungerLevel = 5;
            System.out.println(name + " is very full right now!");
            System.out.println("   ▌▄▄▄▄▄▄▄▌ //");   
            System.out.println("   █ -   - █ ");   
            System.out.println("  █    n    █ "); 
        } else {
            hungerLevel -= amount;
            System.out.println(name + " has been fed. Hunger decreased by " + amount + ".");
            System.out.println("*  ▌▄▄▄▄▄▄▄▌ *");   
            System.out.println(" * █ >   < █ *");   
            System.out.println("* █    O    █ nom nom"); 
        }
    }
    
    //increase happiness level
    public void increaseHappiness(int amount) {
        happiness += amount;
        hungerLevel += 5;
        if (happiness > 100) {
            happiness = 100;
            System.out.println(name + " is very happy right now! Maximum happiness level reached!");
            System.out.println("* **  ▌▄▄▄▄▄▄▄▌ *  *");   
            System.out.println("* * * █ >   < █ **  *");   
            System.out.println("***  █  = U =  █ * **"); 
            System.out.println("*** * * ** * * * * **"); 
        } else {
            System.out.println(name + " is playing. Happiness increased by " + amount + ".");
            System.out.println("   ▌▄▄▄▄▄▄▄▌");   
            System.out.println(" └ █ ^   ^ █ ┐");   
            System.out.println("  █    U    █ "); 
        }
    }
    

    //increase training level
    public void increaseTraining(int amount) {
        trainingLevel += amount;
        hungerLevel += 5;
        if (trainingLevel > 100) {
            trainingLevel = 100;
            System.out.println(name + " is already at the maximum training level.");
            System.out.println("     ▌▄▄▄▄▄▄▄▌ ");   
            System.out.println(" |o_ █ >   < █ _o|");   
            System.out.println("    █    U    █ buff"); 
        } else {
            System.out.println(name + " is training. Training level increased by " + amount + ".");
            System.out.println("    ▌▄▄▄▄▄▄▄▌!!");   
            System.out.println(" |_ █ =   = █ _|");   
            System.out.println("   █    ^    █ "); 
        }
    }
}

public abstract class Location {
    public abstract void performAction(Tamagotchi tamagotchi, String choice);
    public abstract String getLocationName();
    public abstract void displayStatus(Tamagotchi tamagotchi);

    //common actions performed for feed, train, and play choices
    protected void performCommonActions(Tamagotchi tamagotchi, String choice, int hungerDecrease, int trainingIncrease, int happinessIncrease) {
        //switch statement to handle different choices
        switch (choice) {
            case "feed":
                tamagotchi.decreaseHunger(hungerDecrease);
                break;
            case "train":
                tamagotchi.increaseTraining(trainingIncrease);
                break;
            case "play":
                tamagotchi.increaseHappiness(happinessIncrease);
                break;
            default:
                //display message for invalid choice
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class TrainingRoom extends Location {
    @Override
    public String getLocationName() {
        return "Training Room";
    }

    @Override
    public void performAction(Tamagotchi tamagotchi, String choice) {
        //if the choice is "feed" or "play"
        if (choice.equals("feed")){
            System.out.println("Eating is not allowed in the Training Room.");
        } else if (choice.equals("play")){
            System.out.println("Playing is not allowed in the Training Room.");
        } else {
            //choice is neither "feed" nor "play", perform common actions
            performCommonActions(tamagotchi, choice, 0, 20, 0);
        }
    }

    @Override
    public void displayStatus(Tamagotchi tamagotchi) {
        System.out.println("In the Training Room:");
        tamagotchi.displayStatus();
    }
}

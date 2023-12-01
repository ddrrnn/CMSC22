public class Kitchen extends Location {
    //get the name of the location
    @Override
    public String getLocationName() {
        return "Kitchen";
    }

    //perform an action in the Kitchen based on the user's choice
    @Override
    public void performAction(Tamagotchi tamagotchi, String choice) {
        //check if the choice is "train" or "play" and display a message accordingly
        if (choice.equals("train")) {
            System.out.println("Training is not allowed in the Kitchen.");
        } else if (choice.equals("play")){
            System.out.println("Playing is not allowed in the Kitchen.");
        } else {
            //if the choice is not "train" or "play", perform common actions
            performCommonActions(tamagotchi, choice, 30, 0, 0);
        }
    }

    @Override
    public void displayStatus(Tamagotchi tamagotchi) {
        System.out.println("In the Kitchen:");
        tamagotchi.displayStatus();
    }
}

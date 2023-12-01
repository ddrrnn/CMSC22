public class Playground extends Location {
    @Override
    public String getLocationName() {
        return "Playground";
    }

    //perform an action in the Playground based on the user's choice
    @Override
    public void performAction(Tamagotchi tamagotchi, String choice) {
        //if the choice is "feed" or "train" and display a message accordingly
        if (choice.equals("feed")){
            System.out.println("Eating is not allowed in the Playground.");
        } else if (choice.equals("train")){
            System.out.println("Training is not allowed in the Playground.");
        } else {
            //if choice is neither "feed" nor "train", perform common actions
            performCommonActions(tamagotchi, choice, 0, 0, 30);
        }
    }

    @Override
    public void displayStatus(Tamagotchi tamagotchi) {
        System.out.println("In the Playground:");
        tamagotchi.displayStatus();
    }
}

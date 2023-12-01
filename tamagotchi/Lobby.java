public class Lobby extends Location {
    //get the name of the location
    @Override
    public String getLocationName() {
        return "Lobby";
    }

    //perform an action in the Lobby based on the user's choice
    @Override
    public void performAction(Tamagotchi tamagotchi, String choice) {
        //actions performed for feed, train, and play choices
        performCommonActions(tamagotchi, choice, 15, 10, 15);
    }

    //display the status of Tamagotchi in the Lobby
    @Override
    public void displayStatus(Tamagotchi tamagotchi) {
        System.out.println("In the Lobby:");
        tamagotchi.displayStatus();
    }
}

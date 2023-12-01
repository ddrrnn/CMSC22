import java.util.Scanner;

public class TamagotchiGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //tamagotchi's name
        System.out.println("Enter the name for your Tamagotchi: ");
        String tamagotchiName = scanner.nextLine();

        //initialize Tamagotchi
        Tamagotchi tamagotchi = new Tamagotchi(tamagotchiName);
        Location currentLocation = new Lobby(); //initial location

        System.out.println("*  ▌▄▄▄▄▄▄▄▌ *");
        System.out.println(" * █ ∩   ∩ █ *");
        System.out.println("* █  ■■■■■  █ *");
        System.out.println("Hi, I'm " + tamagotchiName + "!");


        while (true) {
            System.out.println("> Feed");
            System.out.println("> Train");
            System.out.println("> Play");
            System.out.println("> Display Status");
            System.out.println("> Change Location");
            System.out.println("> Exit");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "feed":
                case "train":
                case "play":
                    //perform action based on user's choice in the current location
                    currentLocation.performAction(tamagotchi, choice);
                    break;

                case "display status":
                    tamagotchi.displayStatus();
                    break;

                case "change location":
                    System.out.println("Transfer location to where?");
                    System.out.println("Choices: Kitchen, Training Room, Playground");
                    String newLocation = scanner.nextLine().toLowerCase();

                    //check if the new location is different from the current one
                    if (!newLocation.equals(currentLocation.getLocationName().toLowerCase())) {
                        //update current location based on user's choice
                        switch (newLocation) {
                            case "kitchen":
                                currentLocation = new Kitchen();
                                break;
                            case "training room":
                                currentLocation = new TrainingRoom();
                                break;
                            case "playground":
                                currentLocation = new Playground();
                                break;
                            default:
                                System.out.println("Invalid location. Tamagotchi stays in the current location.");
                        }
                    } else {
                        System.out.println("Tamagotchi is already in the " + newLocation + ". Choose a different location.");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting the program.");
                    System.out.println("   ▌▄▄▄▄▄▄▄▌");
                    System.out.println(" └ █ u   u █ ");
                    System.out.println("  █    ^  ; █ bye~ ");
                    System.exit(0);
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

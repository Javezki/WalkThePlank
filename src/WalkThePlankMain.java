
public class WalkThePlankMain {

    private static String difficulty = "easy";
    
    private static int level = 0;
    public static void main(String[] args) throws Exception {
        WalkThePlankGUI gui= new WalkThePlankGUI(); 
        WalkThePlankMulti multi = new WalkThePlankMulti();
        WalkThePlankCampaign camp = new WalkThePlankCampaign("easy", 0);
        intro();
        String user = gui.mainGUI();
        if (userInput(user) == 0) {
            PrintFeatures.printWithDelay("WIP");
            camp.playCampaign();
        }
        else if (userInput(user) == 1)  {
            multi.playMultiPlayer();
        }
        else if (userInput(user) == 2)  {
            System.out.println("ERROR");
        }
    }

    public static int userInput(String user) {
        if (user.contains("m") || user.equals("2")) {
            return 1;
        }
        else if (user.contains("c") || user.equals("1"))    {
            return 0;
        }
        return 2;
    }

    public static void intro()  throws InterruptedException{
        for (int i = 0; i < 30; i++)    {
            System.out.println();
        }
        PrintFeatures.printWithDelay("Welcome");
        Thread.sleep(1000);
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        PrintFeatures.printWithDelay("To...");
        Thread.sleep(1000);
        for (int i = 0; i < 30; i++)    {
            System.out.println();
        }
        WalkThePlankArt.hangmanH();
        for (int i = 0; i < 30; i++)    {
            System.out.println();
        }
        Thread.sleep(1000);
    }
}


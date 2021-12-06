/*
Version: 1.0
Date: 2021-21-05
Author: Javezki
Note: First official program I guess? Save and Load is stupid
*/


public class HangmanMain {

    private static String user = "";
    public static void main(String[] args) throws Exception { 
        HangmanMulti multi = new HangmanMulti();
        HangmanCampaign camp = new HangmanCampaign("Easy", 0);
        intro();
        user = mainGUI();
        while (true)    {
            if (user.equals(""))    {
                user = mainGUI();
            }
            if (userInput(user) == 0) {
                PrintFeatures.printWithDelay("WIP");
                camp.playCampaign();
            }
            else if (userInput(user) == 1)  {
                multi.playMultiPlayer();
            }
            else {
                break;
            }
        }
        HangmanMulti.s.close();
        HangmanCampaign.s.close();

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
        HangmanArt.hangmanH();
        for (int i = 0; i < 30; i++)    {
            System.out.println();
        }
        Thread.sleep(2000);
    }

    public static void setUser(String s)    {
        user = s;
    }

    private static String mainGUI() throws InterruptedException {
        
        PrintFeatures.printWithDelay("Sup dude");
        System.out.println();
        System.out.println();
        PrintFeatures.printWithDelay("What you tryna play? ");
        System.out.println();
        System.out.println("1. Campaign" );
        System.out.println();
        System.out.println("2. MultiPlayer");
        System.out.println();
        System.out.println("3. Exit");
        System.out.println();
        return HangmanMulti.s.nextLine();
    }
}


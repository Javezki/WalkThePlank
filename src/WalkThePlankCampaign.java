

import java.util.ArrayList;
import java.util.Scanner;

public class WalkThePlankCampaign extends Core {

    public static Scanner s = new Scanner (System.in);


    private String difficulty;

    private int level;

    private int failures = 0;

    public WalkThePlankCampaign(String difficulty, int level)   {
        this.difficulty = difficulty;
        this.level = level;
    }

    public void playCampaign() throws InterruptedException  {
        PrintFeatures.printWithDelay("Level: " + level);
        PrintFeatures.printWithDelay("Difficulty: " + difficulty);
        PrintFeatures.printWithDelay("Failures: " + failures);
        System.out.println();
        WordList word = new WordList();
        ArrayList<String> whatWord = new ArrayList<>();
        boolean winner = false;
        if (difficulty.equals("Easy"))  {
            whatWord = word.easyMode();
        }
        else if (difficulty.equals("Medium"))  {
            whatWord = word.mediumMode();
        }
        else if (difficulty.equals("Hard"))    {
            whatWord = word.hardMode();
        }
        String userWord = whatWord.get(level);
        char[] arr = new char[userWord.length()]; // 2
        arr = userWord.toCharArray(); // 3
        while(Core.LIFE != 0)    { // 5
                createWord(userWord, arr); // 6
                displayWord(userWord); // 7
            String userGuess = getPlayerGuess(); // 8
            if (checkUserGuessForWord(userWord, userGuess))    { // 9 
                System.out.println(); // 11
                PrintFeatures.printWithDelay(WordList.randomWinStatement());
                winner = true;
                level++;
                break; // 12
            }
            char userCharGuess = getUserGuess(userWord, userGuess); // 13
            if (isValidInput(userCharGuess, arr))  { //14
                setDisplayWord(userCharGuess, arr); //15
                if(isWinner(userWord.length()))     {
                    System.out.println();
                    PrintFeatures.printWithDelay(WordList.randomWinStatement());
                    level++;
                    winner = true;
                    break;  //16
                }
            }
            System.out.println();
            setLostALifeFalse(); //18
            failures++;
            displayHangman();
        }
        if (!winner) {
            WalkThePlankMain.setUser("");
        }
        resetGame();
        checkLevel();
    }

    
    private String getPlayerGuess()  {
        System.out.println();
        System.out.println("Gimme a good guess: ");
        System.out.println();
        String userGuess = s.nextLine().toLowerCase();
        return userGuess;
    }
    
    private String setDifficulty(String newDiff)  {
        return difficulty = newDiff;
    }

    private void checkLevel() throws InterruptedException {
        if (difficulty.equals("Easy") && level == 21)   {
            setDifficulty("Medium");
            level = 0;
        }
        else if (difficulty.equals("Medium") && level == 21)    {
            setDifficulty("Hard");
            level = 0;
        }
        else if (difficulty.equals("Hard") && level == 11)  {
            PrintFeatures.printWithDelay("How-");
            Thread.sleep(1000);
            PrintFeatures.printWithDelay("This is... Impossible");
            Thread.sleep(1000);
            PrintFeatures.printWithDelay("You really dedicated this much time into hangman?");
            Thread.sleep(3000);
            PrintFeatures.printWithDelay("Congratulations I guess");
            Thread.sleep(2000);
            PrintFeatures.printWithDelay("As a congratulatory reward I guess I'll just give you another blip?");
            PrintFeatures.printWithDelay("You must be tired of astronaunt lol");
            Thread.sleep(3000);
            PrintFeatures.printWithDelay("Ah well ggs");
            SoundFeatures sf = new SoundFeatures();
            Thread.sleep(5000);
            sf.playBlipSound();
            PrintFeatures.printWithDelay("Come find me, Javezki, and I'll try to code something for you?");
            System.exit(0);
        }
    }
}
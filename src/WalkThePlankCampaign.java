import java.util.ArrayList;
import java.util.Scanner;

public class WalkThePlankCampaign extends Core {

    private static Scanner s = new Scanner (System.in);

    private static int easy = 0;

    private String difficulty;

    private int level;

    public WalkThePlankCampaign(String difficulty, int level)   {
        this.difficulty = difficulty;
        this.level = level;
    }

    public void playCampaign() throws InterruptedException  {
        WordList word = new WordList();
        ArrayList<String> whatWord = new ArrayList<>();
        whatWord = word.easyMode();
        String userWord = whatWord.get(easy);
        char[] arr = new char[userWord.length()]; // 2
        arr = userWord.toCharArray(); // 3
        boolean WINNER = false; // 4
        while(Core.LIFE != 0 || WINNER)    { // 5
                createWord(userWord, arr); // 6
                displayWord(userWord); // 7
            String userGuess = getPlayerGuess(); // 8
            if (checkUserGuessForWord(userWord, userGuess))    { // 9
                PrintFeatures.printWithDelay("Holy shit you're insane? You guessed that shit ez"); // 10
                System.out.println(); // 11
                break; // 12
            }
            char userCharGuess = getUserGuess(userWord, userGuess); // 13
            if (isValidInput(userCharGuess, arr))  { //14
                setDisplayWord(userCharGuess, arr); //15
                WINNER = isWinner(userWord.length()); //16
            }
            setLostALifeFalse(); //18
            System.out.println(Core.LIFE);
        }
        resetGame(); //19
        System.out.println("yayayayaya"); //20
        
    }

    
    private String getPlayerGuess()  {
        System.out.println();
        System.out.println("Player two wats ur guess???!??!");
        System.out.println();
        String userGuess = s.nextLine().toLowerCase();
        return userGuess;
    }
}
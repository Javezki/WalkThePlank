import java.util.Scanner;

public class WalkThePlankMulti extends Core {

    private static Scanner s = new Scanner(System.in);

    public void playMultiPlayer() throws InterruptedException   {
        
        String userWord = ""; // 1
        while(isPlayerOneInvalid(userWord))    {
            userWord = getPlayerOneWord();
            if (isPlayerOneInvalid(userWord))  {
                PrintFeatures.printWithDelay("Please enter at least a letter bro");
            }
        }
        //Just some space heheh
        for (int i = 0; i < 50; i++)    {
            System.out.println();
        }

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
        }
        resetGame(); //19
        PrintFeatures.printWithDelay("yayayayaya"); //20
    }

    private String getPlayerOneWord() throws InterruptedException   {
            PrintFeatures.printWithDelay("Whats your word kind sir?");
            String userWord = s.nextLine().toLowerCase();
            return userWord;

    }
    
    private String getPlayerGuess() throws InterruptedException  {
            PrintFeatures.printWithDelay("Player two wats ur guess???!??!");
            String userGuess = s.nextLine().toLowerCase();
            return userGuess;
    }

}
import java.util.ArrayList;

public class Core {

    public static boolean WINNER = false;

    public static int LIFE = 5;

    public static String displayString = "";

    public static int trackCorrect = 0;

    public static int trackIncorrect = 0;

    public static ArrayList<Character> trackUserCharacters = new ArrayList<>();

    private static boolean lostALife = false;

    public static SoundFeatures sound = new SoundFeatures();

    public Core()  {

    }

    public static void createWord(String userWord, char[] arr)    {
        for (int i = 0; i < userWord.length(); i++)    {
            if (isLetter(arr[i])) {
                displayString = displayString + "_";
            }
            else    {
                displayString = displayString + arr[i];
                trackCorrect++;
            }
        }
    }
    public static void displayWord(String userWord) throws InterruptedException   {

        for (int i = 0; i < userWord.length(); i++) {
            System.out.print(displayString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static boolean isPlayerOneInvalid(String userInput)    {
        int validCount = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (!(isLetter(userInput.charAt(i))))  {
                validCount++;
            }
        }
        if (validCount == userInput.length())   {
            return true;
        }
        else    {
            return false;
        }
    }

    public static char getUserGuess(String userWord, String userGuess) throws InterruptedException   {

        sound.playWhooshSound();

        char userCharGuess = 0;
            try {
                userCharGuess = Character.toLowerCase(userGuess.charAt(0));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println();
                PrintFeatures.printWithDelay("sunofagun stop tryna break my shit!");
                System.out.println();
            }
        return userCharGuess;

    }

    public static boolean isValidInput(char userCharGuess, char[] arr) throws InterruptedException {

        if (isLetter(userCharGuess))  {
            return true;
        }
        else    {
            if(lostALife)   {
                return false;
            }
            PrintFeatures.printWithDelay("Invalid character lmao");
            System.out.println();
            lostALife();
            printLife();
            return false;
        }
    }

    public static boolean checkUserGuessForWord(String userWord, String userGuess) throws InterruptedException    {
        if (userGuess.length() == userWord.length()) {
            if (userGuess.equals(userWord)) {
                return true;
            }
            else    {
                if (lostALife)  {
                    return false;
                }
                PrintFeatures.printWithDelay("WRONG! You lost a life hahaha");
                System.out.println();
                lostALife();
                printLife();
                return false;
            }
        }
        else if (userGuess.length() > 1)  {
            if(lostALife)   {
                return false;
            }
            PrintFeatures.printWithDelay("Please only use 1 letter or guess the entire word");
            System.out.println();
            lostALife();
            printLife();
        }
        return false;
    }

    //Fix this shit

    static void setDisplayWord(char userGuess, char[] arr) throws InterruptedException    {
        if (isCharUsed(userGuess))    {
            if(lostALife)   {
                return;
            }
            System.out.println();
            PrintFeatures.printWithDelay("You naughty naughty hehehe, u used dat word b4");
            lostALife();
            printLife();
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++)    {
            if (userGuess == arr[i])  {
                trackUserCharacters.add(userGuess);
                String temp2 = displayString.substring(i + 1);
                String temp1 = displayString.substring(0, i);
                //Font here
                displayString = temp1 + userGuess + temp2;
                trackCorrect++;
            }
        }
        isCorrect();
    }

    private static void isCorrect() throws InterruptedException   {
        if (lostALife)  {
            return;
        }
        if (trackCorrect == trackIncorrect) {
            //Font here
            PrintFeatures.printWithDelay("wrong lmao");
            System.out.println();
            lostALife();
            printLife();
        }
        else {

            //Font here

            PrintFeatures.printWithDelay("Sheesh you're pretty nuts");
            System.out.println();
            trackIncorrect = trackCorrect;
        }
    }

    private static boolean isCharUsed(char userGuess) {
        for (Character i : trackUserCharacters) {
            if (i == userGuess){
                return true;
            }
        }
        return false;
    }

    public static void lostALife() {
        LIFE--;
        lostALife = true;
    }

    public static int getLife()    {
        return LIFE;
    }
    
    private static void printLife() throws InterruptedException {

        //Font here

        PrintFeatures.printWithDelay("You have " + LIFE + " lives left");
        System.out.println();
    }

    public static boolean isWinner()   {
        return WINNER;
    }

    private static boolean isLetter(char userGuess)   {
        if ((int) userGuess >= 65 && (int) userGuess <= 90 || 
        (int) userGuess >= 97 && (int) userGuess  <= 122) {
            return true;
        }
        else    {
            return false;
        }
    }

    public static void resetGame()  {
        WINNER = false;
        LIFE = 5;
        displayString = "";
        trackCorrect = 0;
        trackIncorrect = 0;
        trackUserCharacters.clear();
    }

    public static boolean isWinner(int length)    {
        if  (trackCorrect >= length)   {
            return true;
        }
        else    {
            return false;
        }
    }  

    public static void setLostALifeFalse()   {
        lostALife = false;
    }
}


import java.util.ArrayList;
import java.util.Random;

public class WordList {
    

    public ArrayList<String> easyMode()    {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("word");
        arr.add("tilt");
        arr.add("hood");
        arr.add("rich");
        arr.add("rile");
        arr.add("yell");
        arr.add("gaud");
        arr.add("jail");
        arr.add("data");
        arr.add("lead");
        arr.add("mate");
        arr.add("bike");
        arr.add("that");
        arr.add("were");
        arr.add("wall");
        arr.add("tuba");
        arr.add("fine");
        arr.add("open");
        arr.add("haul");
        arr.add("bang");
        arr.add("howl");
        return arr;
    }

    public ArrayList<String> mediumMode()   {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("awoken");
        arr.add("effect");
        arr.add("degree");
        arr.add("slowed");
        arr.add("locate");
        arr.add("dangle");
        arr.add("demand");
        arr.add("carven");
        arr.add("umpire");
        arr.add("pillar"); 
        arr.add("guided");   
        arr.add("rhythm");
        arr.add("adjure");
        arr.add("seated");
        arr.add("likely");
        arr.add("misled");
        arr.add("taught");
        arr.add("thrust");
        arr.add("implex");
        arr.add("misled");
        arr.add("freebie");
        return arr;
    }
    public ArrayList<String> hardMode() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("newsroom");
        arr.add("tricking");
        arr.add("sparkled");
        arr.add("bartered");
        arr.add("whaleman");
        arr.add("hamulate");
        arr.add("revolter");
        arr.add("inshrine");
        arr.add("bijoutry");
        arr.add("moralize");
        arr.add("pneumonoultramicroscopicsilicovolcanoconiosis");
        return arr;
    }
    public static String randomWinStatement()  {
        String[] youWon = new String[4];
        youWon[0] = "Sick moves dude ";
        youWon[1] = "Good shit bro ";
        youWon[2] = "You're godly? ";
        youWon[3] = "ur BETTER? ";
        Random ran = new Random();
        return youWon[ran.nextInt(0,4)];
    }
}

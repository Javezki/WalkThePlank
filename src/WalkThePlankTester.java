
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class WalkThePlankTester implements Serializable{
    
    private static String difficulty;

    private static int level;

    private static int money;

    public WalkThePlankTester(String difficulty, int level, int money) {
        WalkThePlankTester.difficulty = difficulty;
        WalkThePlankTester.level = level;
        WalkThePlankTester.money = money;
    }

    public static void main(String[] args)  throws InterruptedException {
        // intro();
        // WalkThePlankMulti multi = new WalkThePlankMulti();
        // WalkThePlankGUI gui = new WalkThePlankGUI();
        // gui.mainGUI();
        // JOptionPane.showConfirmDialog(null, "Press OK to cancel", "Just chiling", 0);
        SaveAndLoad sal = new SaveAndLoad("hard", 2, 1);
        String[] s = sal.load();
        SaveAndLoad.decode(s);
    }
    public static void intro()  throws InterruptedException{
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

    public void load()  {
        WalkThePlankTester w = null;
        try {
            FileInputStream fileIn = new FileInputStream(new File("things.ser"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            w = (WalkThePlankTester) in.readObject();
            fileIn.close();
        }
        catch (IOException e)   {
            e.printStackTrace();
            return;
        }
        catch (ClassNotFoundException e)    {
            e.printStackTrace();
            return;
        }
    }

    public void save()   {
        WalkThePlankTester w = new WalkThePlankTester("hard",4 , 3);
        String path = System.getProperty("user.dir") + "tester.ser";
        String path2 = getClass().toString() + "things.ser";
        System.out.println(path);
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("things.ser"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(w);
            out.close();
            fileOut.close();
            System.out.printf("Saved in somehwere");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDifficulty()  {
        return WalkThePlankTester.difficulty;
    }

    public static int getLevel()    {
        return WalkThePlankTester.level;
    }

    public static int getMoney()    {
        return WalkThePlankTester.money;
    }
}

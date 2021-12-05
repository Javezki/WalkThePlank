import java.util.concurrent.TimeUnit;

public class PrintFeatures {


    public static void printWithDelay(String data)   throws InterruptedException{
        TimeUnit unit = TimeUnit.MILLISECONDS;
        for (char ch : data.toCharArray())  {
            System.out.print(ch);
            Core.sound.playBlipSound();
            unit.sleep(50);
        }
        System.out.println();
    }

    public static void printWithDelayNoEnter(String data)   throws InterruptedException {
        TimeUnit unit = TimeUnit.MILLISECONDS;
        for (char ch : data.toCharArray())  {
            System.out.print(ch);
            Core.sound.playBlipSound();
            unit.sleep(50);
        }
    }  
}

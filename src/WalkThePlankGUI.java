

public class WalkThePlankGUI extends Core{
    
    public String mainGUI() throws InterruptedException {
        
        PrintFeatures.printWithDelay("Hello there Stranger!");
        System.out.println();
        System.out.println();
        PrintFeatures.printWithDelay("What gamemode would you like to play? ");
        System.out.println();
        System.out.println("1. Campaign" );
        System.out.println();
        System.out.println("2. MultiPlayer");
        System.out.println();
        System.out.print(": ");
        return WalkThePlankMulti.s.nextLine();
    }
}

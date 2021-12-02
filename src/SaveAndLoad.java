import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Base64.*;

public class SaveAndLoad {

    private String difficulty;

    private int level;

    private int money;
    
    public SaveAndLoad(String difficulty, int level, int money) {
        this.difficulty = difficulty;
        this.level = level;
        this.money = money;
    }

    public void save()   {
        String[] s = encode(difficulty, level, money);
        try {
            Properties properties = new Properties();
            properties.setProperty("difficulty", s[0]);
            properties.setProperty("level", s[1]);
            properties.setProperty("money", s[2]);

            File file = new File("progress.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "The current progress");
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String[] load()  {
        try {
            File file = new File("progress.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration enumKeys = properties.keys();
            String[] s = new String[3];
            int i = 0;
            while (enumKeys.hasMoreElements())  {
                String key = (String) enumKeys.nextElement();
                String value = properties.getProperty(key);
                s[i] = value;
                System.out.println(key + " : " + value);
            }
            return s;
        } catch (Exception e) {
            String[] s = new String[1];
            return s;
        }
        
    }
    public String[] encode(String difficulty, int level, int money)    {
        String encodedDifficulty = Base64.getEncoder().encodeToString(difficulty.getBytes());
        String encodedLevel = Base64.getEncoder().encodeToString(Integer.toString(level).getBytes());
        String encodedMoney = Base64.getEncoder().encodeToString(Integer.toString(money).getBytes());
        String[] s = {encodedDifficulty, encodedLevel, encodedMoney};
        return s;
    }
    public static String[] decode(String[] s)  {
        byte[] decodedDifficulty = Base64.getDecoder().decode(s[0]);
        byte[] decodedLevel = Base64.getDecoder().decode(s[1]);
        byte[] decodedMoney = Base64.getDecoder().decode(s[2]);

        s[0] = decodedDifficulty.toString();
        s[1] = decodedLevel.toString();
        s[2] = decodedMoney.toString();

        System.out.println(s[0] + " " + s[1] + " " + s[2]);

        return s;
    }
}

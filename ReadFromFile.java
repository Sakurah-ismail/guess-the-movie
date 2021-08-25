import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ReadFromFile
{
    public static String array[] = new String[100];

    static String ReadAndScanFile() throws FileNotFoundException
    {
        File movieTitlefile = new File("MovieTitles.txt");
        Scanner scan = new Scanner(movieTitlefile);
        int i = 0;
        while(scan.hasNextLine())
        {
            array[i] = scan.nextLine();
            i += 1;
        }
        int index = TakeRandomIndex(i);

        return array[index];
    }

    static int TakeRandomIndex(int r)
    {
        Random dice = new Random();
        int number = dice.nextInt(r);
        return number;
    }
}

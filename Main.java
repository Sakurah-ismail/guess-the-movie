import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String selectedOne = ReadFromFile.ReadAndScanFile();
        char[] movie = selectedOne.toCharArray();

        ShowWhatToDo(movie);
    }

    public static void ShowWhatToDo(char[] movie)
    {
        Scanner scan = new Scanner(System.in);
        char input = '0';
        boolean end = false;
        int wrongGuess = 0;
        char[] wrongGuesses = new char[20];
        char[] inputedName = new char[movie.length];
        int right = 0;
        int countMatch = 0;
        int countSpace = 0;

        System.out.print("You are guessing:");
        for(int i = 0; i < movie.length; i++)
        {
            if(movie[i] != ' ')
            {
                inputedName[i] = '_';
            }
            else
            {
                inputedName[i] = ' ';
                countSpace++;
            }
            System.out.print(inputedName[i]);
        }
        System.out.print("\n");

        while(!end)
        {

            System.out.print("You have guessed (" + wrongGuess + ") wrong letters:");
            for(int i = 0; wrongGuesses[i] != '\0' ; i++){
                System.out.print(wrongGuesses[i] + " ");
            }
            System.out.print("\n");

            System.out.print("Guess a letter :");



            input = scan.next().charAt(0);

            for(int i = 0; i < movie.length; i++) {
                if(input == movie[i]){
                    if(inputedName[i] != movie[i])
                        countMatch++;
                    inputedName[i] = movie[i];

                }
            }
            if(countMatch == 0)
            {
                wrongGuesses[wrongGuess] = input;
                wrongGuess++;
            }
            else
            {
                right += countMatch;
            }

            if(wrongGuess >= 10)
            {
                System.out.println("You have Lost");
                break;
            }
            if(right + countSpace == movie.length)
            {
                System.out.println("You win!");
                System.out.println("You have guessed '" + String.valueOf(movie) + "' correctly");
                break;
            }

            System.out.print("You are guessing:");
            countMatch = 0;
            for(int i = 0; i < movie.length; i++)
            {
                System.out.print(inputedName[i]);
            }
            System.out.print("\n");
        }
    }
}

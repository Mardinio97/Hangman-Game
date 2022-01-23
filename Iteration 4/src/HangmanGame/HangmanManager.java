package HangmanGame;

import java.util.ArrayList;
import java.util.Scanner;
import static HangmanGame.WordList.*;

public class HangmanManager {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Character> TrueGuess, FalseGuess;
    private String wordToGuess;
    private int score;
    private HangmanManager manager ;


    public HangmanManager() {
        this.wordToGuess = randomWord();
        this.FalseGuess = new ArrayList<>();
        this.TrueGuess = new ArrayList<>();
        for (int i = 0; i < getWordToGuess().length(); i++)
            this.TrueGuess.add('_');
    }

    public void GameStart() {
        while (!endGame()) {
            System.out.println(Sketch());
            for (Character character : TrueGuess)
                System.out.print(character + " ");
            System.out.println();

            System.out.print("Wrong guesses: ");
            for (Character character : FalseGuess)
                System.out.print(character + " ");
            System.out.println();
            System.out.print("Type a letter: ");
            String guess = scan.nextLine().toLowerCase();
            System.out.println("_to quit type 0_");
            GuessChecck(guess.charAt(0));
            if (guess.equals("0")) {
                System.err.print("Are you sure you want to quit the game?(yes/no): ");
                String confirm = scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    System.exit(1);
                }
                else if (confirm.equalsIgnoreCase("no") ){
                    manager = new HangmanManager();
                    manager.GameStart();
                }
            }


            if (endGame())
                break;
        }
        if (endGame()) {
            System.out.println();
            System.out.println(Sketch());
            System.out.println(getStatus());
            System.out.println("|| your score is: " + seeScore() + " ||");
            System.out.println("The  word is: " + getWordToGuess());



        }
        System.out.println("Would you like to play another round (yes/no) ?");
        String restart =scan.nextLine();
        if(restart.equalsIgnoreCase("yes")) {
            manager = new HangmanManager();
            manager.GameStart();
        }
        else
            System.out.println("GoodBye :D");
            System.exit(0);


    }
    public boolean Win() {
        return !TrueGuess.contains('_');
    }


    public boolean Lose() {
        return FalseGuess.size() >= 6;
    }

    public boolean endGame() {
        return Lose() || Win();
    }


    public void GuessChecck(char word) {
        boolean test = false;
        for (int i = 0; i < wordToGuess.length(); i++)
            if (wordToGuess.charAt(i) == word) {
                test = true;
                TrueGuess.set(i, word);
            }
            if (!test)
                FalseGuess.add(word);



    }


    public String Sketch() {
        int incorrect = FalseGuess.size();
        if (incorrect == 0)
            return " |\n |\n |\n |\n_|_";
        else if (incorrect == 1)
            return "  ___\n |   |\n |\n |\n |\n_|_";

        else if (incorrect == 2)
            return "  ___\n |   |\n |   o\n |\n |\n_|_";
        else if (incorrect == 3)
            return "  ___\n |   |\n |   o\n |  /|\\\n |\n_|_";

        else if (incorrect == 4)
            return "  ___\n |   |\n |   o\n |  /|\\\n |  / \n_|_";

        else
            return "  ___\n |   |\n |   o\n |  /|\\\n |  / \\\n_|_";
    }

    public String getStatus() {
        return Win() ? "******* Well done you WIN :D *******" : "******* YOU LOSE :( *******";
    }


    public int seeScore() {// remove the commenting to have a successful automated test-

        if (FalseGuess.size() == 0 )
            score = 100;
        else if(FalseGuess.size()==1) {
            score = 75;
        }
            else if (FalseGuess.size()==2){
                score=50;
            }
        else if (FalseGuess.size()==4){
            score=25;
        }
        else if (FalseGuess.size()==5){
            score=10;
        }
            else
            score = 0;
        return score;

       /*  return 0;*/
    }


    /**
     * Helper Methods
     **/
    public ArrayList<Character> getCorrectGuess() {
        return TrueGuess;
    }

    public void setCorrectGuess(ArrayList<Character> correctGuess) {
        this.TrueGuess = correctGuess;
    }

    public ArrayList<Character> getIncorrectGuess() {
        return FalseGuess;
    }
    public void setIncorrectGuess(ArrayList<Character> incorrectGuess) {
        this.FalseGuess = incorrectGuess;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }
}
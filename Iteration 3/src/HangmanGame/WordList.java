package HangmanGame;

import java.util.Random;

public class WordList  {
    private static String[] MixWords = {
            "heaven", "hide"
            /*, "caterpillar", "spoon", "watermelon", "laptop", "toe", "toad"
            , "fundamental", "capitol", "garbage", "anticipate", "apple"*/
    };
    public static String randomWord() {
        Random randIndex = new Random();
        int index = randIndex.nextInt(MixWords.length);
        return MixWords[index];
    }





}

package HangmanGame;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class HangmanManagerTest {

    @Test
    void TestStatue() {
        HangmanManager unitGameStatus = new HangmanManager();
        unitGameStatus.setWordToGuess("yo");

        ArrayList<Character> correct = new ArrayList<Character>(2);
        correct.add('y');
        correct.add('o');
        unitGameStatus.setCorrectGuess(correct);
        assertEquals("******* Well done you WIN :D *******", unitGameStatus.getStatus());

        HangmanManager unitGameStatusLose = new HangmanManager();
        unitGameStatusLose.setWordToGuess("cry");
        ArrayList<Character> incorrect = new ArrayList<Character>(5);
        incorrect.add('p');
        incorrect.add('i');
        incorrect.add('u');
        incorrect.add('m');
        incorrect.add('f');
        unitGameStatusLose.setIncorrectGuess(incorrect);
        assertEquals("******* YOU LOSE :( *******", unitGameStatusLose.getStatus());
    }


    @Test
    void TestLose() {
        HangmanManager unitLose = new HangmanManager();
        assertFalse(unitLose.Lose());
        unitLose.setWordToGuess("sleep");
        ArrayList<Character> incorrect = new ArrayList<Character>(4);
        incorrect.add('H');
        incorrect.add('i');
        incorrect.add('c');
        incorrect.add('k');
        incorrect.add('l');
        incorrect.add('o');
        unitLose.setIncorrectGuess(incorrect);
        assertTrue(unitLose.Lose());
    }
    @Test
    void TestNotLose() {
        HangmanManager unitLose = new HangmanManager();
        assertFalse(unitLose.Lose());
        unitLose.setWordToGuess("sleep");
        ArrayList<Character> incorrect = new ArrayList<Character>(4);
        incorrect.add('s');
        incorrect.add('l');
        incorrect.add('e');
        incorrect.add('e');
        incorrect.add('p');
        unitLose.setIncorrectGuess(incorrect);
        assertFalse(unitLose.Lose());
    }
    @Test
    void TestWin() {
        HangmanManager unitWin = new HangmanManager();
        assertFalse(unitWin.Win());
        unitWin.setWordToGuess("bye");
        ArrayList<Character> correct = new ArrayList<Character>(4);
        correct.add('b');
        correct.add('y');
        correct.add('e');
        unitWin.setCorrectGuess(correct);
        assertTrue(unitWin.Win());
    }

    @Test
    void TestNotWin() {
        HangmanManager unitWin = new HangmanManager();
        assertFalse(unitWin.Win());
        unitWin.setWordToGuess("cheese");
        ArrayList<Character> correct = new ArrayList<Character>(6);
        correct.add('b');
        correct.add('y');
        correct.add('e');
        unitWin.setCorrectGuess(correct);
        assertTrue(unitWin.Win());
    }

    @Test
    void TestSketch() {
        HangmanManager unit = new HangmanManager();
        String expected1 = " |\n |\n |\n |\n_|_";
        assertEquals(expected1, unit.Sketch());
        unit.setWordToGuess("name");
        ArrayList<Character> fill = new ArrayList<Character>(4);
        fill.add('w');
        fill.add('q');
        fill.add('t');
        fill.add('u');
        String E = "  ___\n |   |\n |   o\n |  /|\\\n |  / \n_|_";
        unit.setIncorrectGuess(fill);
        assertEquals(E, unit.Sketch());
    }



    @Test
    void TestScore() { /////Note:this test will fail
        HangmanManager unitScore = new HangmanManager();
        unitScore.setWordToGuess("David");
        ArrayList<Character> correct = new ArrayList<>(4);
        ArrayList<Character> incorrect = new ArrayList<>(4);
        correct.add('D');
        correct.add('a');
        correct.add('v');
        correct.add('i');
        correct.add('d');

        unitScore.setIncorrectGuess(incorrect);
        unitScore.setCorrectGuess(correct);
        assertEquals(100, unitScore.seeScore());
    }



    @Test
    void testEndGame() {
        HangmanManager unitEndGame = new HangmanManager();
        assertFalse(unitEndGame.endGame());
        unitEndGame.setWordToGuess("hi");
        ArrayList<Character> correct = new ArrayList<Character>(2);
        correct.add('_');
        correct.add('_');
        unitEndGame.setCorrectGuess(correct);
        assertFalse(unitEndGame.endGame());
        correct.clear();
        correct.add('w');
        correct.add('c');
        assertTrue(unitEndGame.endGame());
    }


}
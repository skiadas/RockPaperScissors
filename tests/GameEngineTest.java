import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {

    private GameEngine engine;

    @Before
    public void setUp() {
        engine = new GameEngine();
    }

    @Test
    public void testRunMethodWorks() {
        assertInputResultsInExpectedOutput(
                "Rock\n",
                "You played Rock\n" +
                        "Opponent played Rock\n" +
                        "It's a tie!\n");
    }

    @Test
    public void testRunMethodWorksWithTwoPlays() {
        assertInputResultsInExpectedOutput(
                "Rock\nPaper\n",
                "You played Rock\n" +
                        "Opponent played Rock\n" +
                        "It's a tie!\n" +
                        "You played Paper\n" +
                        "Opponent played Rock\n" +
                        "You win!\n");
    }

    private void assertInputResultsInExpectedOutput(String input, String expected) {
        Scanner scanner = new Scanner(input);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);
        engine.run(scanner, out);
        assertEquals(expected, byteArrayOutputStream.toString());
    }
}

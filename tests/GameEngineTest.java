import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {
    @Test
    public void testRunMethodWorks() {
        // Arrange
        GameEngine engine = new GameEngine();
        Scanner scanner = new Scanner("Rock\n");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);
        // Act
        engine.run(scanner, out);
        // Assert
        assertEquals("You played Rock\n" +
                             "Opponent played Rock\n" +
                             "It's a tie!\n",
                     byteArrayOutputStream.toString());
    }

    @Test
    public void testRunMethodWorksWithTwoPlays() {
        GameEngine engine = new GameEngine();
        Scanner scanner = new Scanner("Rock\nPaper\n");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);
        engine.run(scanner, out);
        assertEquals("You played Rock\n" +
                             "Opponent played Rock\n" +
                             "It's a tie!\n" +
                             "You played Paper\n" +
                             "Opponent played Rock\n" +
                             "You win!\n",
                     byteArrayOutputStream.toString());
    }
}

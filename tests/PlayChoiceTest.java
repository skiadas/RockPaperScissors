// 1. Don't write prod code unless you have failing test
// 2. Don't write more of a test than is needed to have something failing
// 3. Don't write more prod code than needed to pass the failing test
// 4. Think about refactoring before going back to a failing test

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// List of test
// rock beats scissors
// paper beats rock
// ... ?
public class PlayChoiceTest {
    @Test
    public void testBeatsTrueCases() {
        assertTrue(PlayChoice.Rock.beats(PlayChoice.Scissors));
        assertTrue(PlayChoice.Paper.beats(PlayChoice.Rock));
        assertTrue(PlayChoice.Scissors.beats(PlayChoice.Paper));
    }

    @Test
    public void testBeatsFalseCases() {
        assertFalse(PlayChoice.Rock.beats(PlayChoice.Paper));
    }
}

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    @Test
    public void testResults() {
        assertResult(PlayChoice.Rock, PlayChoice.Scissors, Result.Win);
        assertResult(PlayChoice.Scissors, PlayChoice.Paper, Result.Win);
        assertResult(PlayChoice.Paper, PlayChoice.Rock, Result.Win);
        assertResult(PlayChoice.Rock, PlayChoice.Paper, Result.Lose);
        assertResult(PlayChoice.Scissors, PlayChoice.Rock, Result.Lose);
        assertResult(PlayChoice.Paper, PlayChoice.Scissors, Result.Lose);
        assertResult(PlayChoice.Rock, PlayChoice.Rock, Result.Tie);
        assertResult(PlayChoice.Scissors, PlayChoice.Scissors, Result.Tie);
        assertResult(PlayChoice.Paper, PlayChoice.Paper, Result.Tie);
    }

    private static void assertResult(PlayChoice player, PlayChoice opponent, Result expected) {
        Result result = Result.compare(player, opponent);
        assertEquals(expected, result);
    }
}

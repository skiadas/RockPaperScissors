import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameEngineUnitTest {
    @Test
    public void testOneRound() {
        // arrange
        PresenterSpy presenter = new PresenterSpy();
        Iterable<PlayChoice> list = null;
        GameEngine engine = new GameEngine(presenter, list);
        // act
        engine.processPlay(PlayChoice.Paper);
        // ... assert
        assertTrue(presenter.reportResultsWasCalled);
        assertEquals(1, presenter.reportResultsCallCount);
        assertEquals(PlayChoice.Paper, presenter.lastPlayChoice);
        assertEquals(PlayChoice.Rock, presenter.lastAiChoice);
        assertEquals(Result.Win, presenter.lastResult);
    }

    @Test
    public void testRunMethod() {
        PresenterSpy presenter = new PresenterSpy();
        Iterable<PlayChoice> list = List.of(
                PlayChoice.Scissors,
                PlayChoice.Rock,
                PlayChoice.Rock);
        GameEngine engine = new GameEngine(presenter, list);
        engine.run();
        assertEquals(3, presenter.reportResultsCallCount);
    }

    private static class PresenterSpy implements Presenter {
        boolean reportResultsWasCalled = false;
        int reportResultsCallCount = 0;
        PlayChoice lastPlayChoice = null;
        PlayChoice lastAiChoice = null;
        Result lastResult = null;

        public void reportError() {

        }

        public void reportResults(PlayChoice playChoice, PlayChoice aiChoice, Result result) {
            reportResultsWasCalled = true;
            reportResultsCallCount += 1;
            lastPlayChoice = playChoice;
            lastAiChoice = aiChoice;
            lastResult = result;
        }
    }
}

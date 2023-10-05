import java.util.Iterator;

public class GameEngine {

    private final OpponentAI ai;
    private final Presenter presenter;
    private final Iterator<PlayChoice> ui;
    private PlayChoice lastPlay;

    public GameEngine(Presenter presenter, Iterable<PlayChoice> ui) {
        this(presenter, ui.iterator(), new LastPlayOpponentAI());
    }

    public GameEngine(Presenter presenter, Iterator<PlayChoice> ui) {
        this(presenter, ui, new LastPlayOpponentAI());
    }

    public GameEngine(Presenter presenter, Iterable<PlayChoice> ui, OpponentAI opponentAI) {
        this(presenter, ui.iterator(), opponentAI);
    }

    public GameEngine(Presenter presenter, Iterator<PlayChoice> ui, OpponentAI opponentAI) {
        ai = opponentAI;
        lastPlay = null;
        this.ui = ui;
        this.presenter = presenter;
    }

    // 1. Loop logic
    // 2. user input converted to play choice
        // 3. choice of ai play
        // 4. compare --> get result
        // 5. rock beats scissors
    // 6. reporting results

    void run() {
        while(ui.hasNext()) {
            try {
                PlayChoice playChoice = ui.next();
                processPlay(playChoice);
            } catch (RuntimeException e) {
                presenter.reportError();
            }
        }
    }

    void processPlay(PlayChoice playChoice) {
        PlayChoice aiChoice = ai.play(lastPlay);
        lastPlay = playChoice;
        Result result = Result.compare(playChoice, aiChoice);
        presenter.reportResults(playChoice, aiChoice, result);
    }
}

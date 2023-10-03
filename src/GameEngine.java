import java.util.Scanner;

public class GameEngine {

    private final OpponentAI ai;
    private final Scanner scanner;
    private final Presenter presenter;
    private PlayChoice lastPlay;

    public GameEngine(Scanner scanner, Presenter presenter) {
        ai = new OpponentAI();
        lastPlay = null;
        this.scanner = scanner;
        this.presenter = presenter;
    }

    // 1. Loop logic
    // 2. user input converted to play choice
        // 3. choice of ai play
        // 4. compare --> get result
        // 5. rock beats scissors
    // 6. reporting results

    void run() {
        while(scanner.hasNext()) {
            String next = scanner.next();
            try {
                PlayChoice playChoice = PlayChoice.valueOf(next);
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

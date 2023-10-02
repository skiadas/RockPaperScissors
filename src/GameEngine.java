import java.io.PrintStream;
import java.util.Scanner;

public class GameEngine {

    private final OpponentAI ai;
    private final Scanner scanner;
    private final PrintStream out;
    private PlayChoice lastPlay;

    public GameEngine(Scanner scanner, PrintStream out) {
        ai = new OpponentAI();
        lastPlay = null;
        this.scanner = scanner;
        this.out = out;
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
                reportError();
            }
        }
    }

    private void reportError() {
        out.println("That's not a valid play! Try again.");
    }

    void processPlay(PlayChoice playChoice) {
        PlayChoice aiChoice = ai.play(lastPlay);
        lastPlay = playChoice;
        Result result = Result.compare(playChoice, aiChoice);
        reportResults(playChoice, aiChoice, result);
    }

    private void reportResults(PlayChoice playChoice, PlayChoice aiChoice, Result result) {
        out.printf("You played %s%n", playChoice);
        out.printf("Opponent played %s%n", aiChoice);
        out.println(result.getMessage());
    }
}

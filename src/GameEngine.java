import java.io.PrintStream;
import java.util.Scanner;

public class GameEngine {
    void run() {
        run(new Scanner(System.in), System.out);
    }

    // 1. Loop logic
    // 2. user input converted to play choice
        // 3. choice of ai play
        // 4. compare --> get result
        // 5. rock beats scissors
    // 6. reporting results

    void run(Scanner scanner, PrintStream out) {
        OpponentAI ai = new OpponentAI();
        PlayChoice lastPlay = null;
        while(scanner.hasNext()) {
            String next = scanner.next();
            try {
                PlayChoice playChoice = PlayChoice.valueOf(next);
                PlayChoice aiChoice = ai.play(lastPlay);
                lastPlay = playChoice;
                Result result = Result.compare(playChoice, aiChoice);
                out.printf("You played %s%n", playChoice);
                out.printf("Opponent played %s%n", aiChoice);
                out.println(result.getMessage());
            } catch (RuntimeException e) {
                out.println("That's not a valid play! Try again.");
            }
        }
    }
}

import java.io.PrintStream;
import java.util.Scanner;

public class GameEngine {
    void run() {
        // Loop:
        // 1. user types
        // 2. opponent plays
        // 3. compare and report
        // 4. loop back
        run(new Scanner(System.in), System.out);
    }

    void run(Scanner scanner, PrintStream out) {
        OpponentAI ai = new OpponentAI();
        PlayChoice lastPlay = null;
        while(scanner.hasNext()) {
            String next = scanner.next();
            try {
                PlayChoice playChoice = PlayChoice.valueOf(next);
                PlayChoice aiChoice = ai.play(lastPlay);
                lastPlay = playChoice;
                Result result = compare(playChoice, aiChoice);
                out.printf("You played %s%n", playChoice);
                out.printf("Opponent played %s%n", aiChoice);
                out.println(result.getMessage());
            } catch (RuntimeException e) {
                out.println("That's not a valid play! Try again.");
            }
        }
    }

    private Result compare(PlayChoice playChoice, PlayChoice aiChoice) {
        if (playChoice.beats(aiChoice)) return Result.Win;
        if (aiChoice.beats(playChoice)) return Result.Lose;
        return Result.Tie;
    }
}

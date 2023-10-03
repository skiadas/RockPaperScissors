import java.io.PrintStream;

public class Presenter {
    private final PrintStream out;

    public Presenter(PrintStream out) {
        this.out = out;
    }

    void reportError() {
        out.println("That's not a valid play! Try again.");
    }

    void reportResults(PlayChoice playChoice, PlayChoice aiChoice, Result result) {
        out.printf("You played %s%n", playChoice);
        out.printf("Opponent played %s%n", aiChoice);
        out.println(result.getMessage());
    }
}
import java.io.PrintStream;

public class PrintStreamPresenter implements Presenter {
    private final PrintStream out;

    public PrintStreamPresenter(PrintStream out) {
        this.out = out;
    }

    public void reportError() {
        out.println("That's not a valid play! Try again.");
    }

    public void reportResults(PlayChoice playChoice, PlayChoice aiChoice, Result result) {
        out.printf("You played %s%n", playChoice);
        out.printf("Opponent played %s%n", aiChoice);
        out.println(result.getMessage());
    }
}
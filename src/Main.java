import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Presenter presenter = new PrintStreamPresenter(System.out);
        UI ui = new UI(scanner);
        GameEngine gameEngine = new GameEngine(presenter, ui);
        gameEngine.run();
    }
}


// Rock - Paper - Scissors

// Type in a choice
// Opponent generates answer
// Compare, report result
// Go again

// Opponent strategy:
// first time goes rock
// uses whatever you used last


// Classes:
// MainEngine: reads input, calls opponentAI, compares
// OpponentAI: some sort of "play" method
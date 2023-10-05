import java.util.Iterator;
import java.util.Scanner;

public class UI implements Iterator<PlayChoice> {
    private final Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public PlayChoice next() {
        String next = scanner.next();
        return PlayChoice.valueOf(next);
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }
}
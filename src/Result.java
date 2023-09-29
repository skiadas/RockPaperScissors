public enum Result {
    Win {
        String getMessage() {
            return "You win!";
        }
    },
    Tie {
        String getMessage() {
            return "It's a tie!";
        }
    },
    Lose {
        String getMessage() {
            return "You lose";
        }
    };

    abstract String getMessage();
    String getMessage2() {
        switch (this) {
            case Lose: return "You lose!";
            case Win: return "You win!";
            case Tie: return "It's a tie!";
        }
        throw new RuntimeException("Shouldn't get here");
    }
}

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

    static Result compare(PlayChoice player, PlayChoice ai) {
        if (player.beats(ai)) return Win;
        if (ai.beats(player)) return Lose;
        return Tie;
    }

    abstract String getMessage();
}

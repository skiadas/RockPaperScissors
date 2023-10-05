public class LastPlayOpponentAI implements OpponentAI {
    public PlayChoice play(PlayChoice lastPlayerPlay) {
        if (lastPlayerPlay == null) return PlayChoice.Rock;
        return lastPlayerPlay;
    }
}

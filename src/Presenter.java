public interface Presenter {
    void reportError();
    void reportResults(PlayChoice playChoice, PlayChoice aiChoice, Result result);
}

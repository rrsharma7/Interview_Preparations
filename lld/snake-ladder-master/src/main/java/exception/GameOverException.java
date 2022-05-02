package exception;

public class GameOverException extends Exception {
    public GameOverException(String game_is_already_over) {
        super(game_is_already_over);
    }
}

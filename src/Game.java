import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public abstract class Game {

    public static void main(String[] args) throws NotImplementedException {
        startGame();
    }

    public static void initializeGame() throws NotImplementedException {
        throw new NotImplementedException("");
    }

    private static void startGame() throws NotImplementedException {
        throw new NotImplementedException("");
    }
}

package Game;


import Board.*;

public interface Game {
    public Board board = null;

    void initializeGame(int columns, int rows);

    public void startGame();

}

package Game;
import Board.*;
import Players.FIALPlayersManager;

public class FourInLineGame implements Game {
    public Board board;
    public BoardManager boardManager;
    public FIALPlayersList playersList;
    public FIALPlayersManager playersManager;
    public FourInLineGame(int columns, int rows) {
        initializeGame(columns, rows);
    }

    @Override
    public void initializeGame(int columns, int rows) {
        this.board = new FourInALineBoard(columns, rows, ' ');
        this.boardManager = new BoardManager(this.board);
        this.playersList = new FIALPlayersList(this.boardManager);
        this.playersManager = new FIALPlayersManager(playersList);
    }

    @Override
    public void startGame() {
        this.boardManager.clearBoard();
            this.boardManager.drawBoard();
        while (true) {
            this.playersManager.executeCurrentPlayerMove();
            this.boardManager.drawBoard();
            this.playersManager.changePlayer();
        }
    }
}

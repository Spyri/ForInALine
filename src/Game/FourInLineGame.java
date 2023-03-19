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
        this.playersList = new FIALPlayersList();
        this.playersManager = new FIALPlayersManager(playersList);
    }

    @Override
    public void startGame() {
        this.boardManager.clearBoard();
        this.boardManager.drawBoard();
        for (int i = 0; i < 8; i++) {
            this.boardManager.setPieceAt('G', 1);
            this.boardManager.drawBoard();
        }
    }
}

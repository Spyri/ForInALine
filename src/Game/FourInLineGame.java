package Game;
import Board.*;

public class FourInLineGame implements Game {
    public Board board;
    public BoardManager manager;
    public FourInLineGame(int columns, int rows) {
        this.board = new FourInALineBoard(columns, rows, ' ');
        this.manager = new BoardManager(this.board);
    }

    @Override
    public void initializeGame() {


    }

    @Override
    public void startGame() {
        this.manager.clearBoard();
        this.manager.drawBoard();
        for (int i = 0; i < 8; i++) {
            this.manager.setPieceAt('G', 1);
            this.manager.drawBoard();
        }
    }
}

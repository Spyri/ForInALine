package Board;

public class BoardManager {
    public Board board;
    private PieceOnFIALBoardSetter pieceSetter;

    public BoardManager(Board board) {
        this.board = board;
        this.pieceSetter = new PieceOnFIALBoardSetter(this.board);
    }

    public boolean setPieceAt(char p, int row) {
        return this.pieceSetter.setPieceAt(p, row);
    }

    public void clearBoard() {
        this.board.clearBoard();
    }

    public void drawBoard() {
        for (int column = 0; column < this.board.maxColumn; column++) {
            System.out.print('|');
            for (int row = 0; row < this.board.maxRow; row++) {
                System.out.print(this.board.getPieceAt(column, row) + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * this.board.maxRow + 1; i++) {
            System.out.print('-');
        }
        System.out.println();
        for (int row = 0; row < this.board.maxRow; row++) {
            System.out.print(" " + row) ;
        }
        System.out.println("\n");
    }
}

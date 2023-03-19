package Board;

public abstract class Board {
    protected int maxColumn;
    protected int maxRow;
    char[][] board;
    char blankPiece;


    public void setPieceAt(char p, int column, int row) {
        this.board[column][row] = p;
    }

    public char getPieceAt(int column, int row) {
        return this.board[column][row];
    }

    public void clearBoard() {
        for (int column = 0; column < this.maxColumn; column++) {
            for (int row = 0; row < this.maxRow; row++) {
                this.setPieceAt(this.blankPiece, column, row);
            }
        }
    }
}

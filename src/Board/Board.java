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

    public int getAreaOfBoard() {
        return this.maxColumn*this.maxRow;
    }

    public boolean checkNotInBounds(int column, int row) {
        return column > this.maxColumn - 1 || row > this.maxRow - 1 || column < 0 || row < 0;
    }

    public int getMaxRow() {
        return this.maxRow;
    }
}

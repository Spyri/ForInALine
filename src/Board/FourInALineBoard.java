package Board;

public class FourInALineBoard extends Board {
    public FourInALineBoard(int column, int rows, char c) {
        this.maxColumn = column;
        this.maxRow = rows;
        this.blankPiece = c;
        this.board = new char[column][rows];
    }



}

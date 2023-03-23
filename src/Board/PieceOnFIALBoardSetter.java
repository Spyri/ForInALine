package Board;

import IO.InputOutput;

public class PieceOnFIALBoardSetter {
    private final Board board;
    public PieceOnFIALBoardSetter(Board board) {
        this.board = board;
    }

    public boolean setPieceAt(char p, int row) {
        if (!checkBoundAndRowWithoutOutput(0, row)) {
            return false;
        }
        else {
            this.board.setPieceAt(p, this.getNextFreeColumnOfRow(row), row);
            return true;
        }

    }


    public boolean checkBoundAndRowWithoutOutput(int column, int row) {
        return !this.board.checkNotInBounds(column,row) && isRowFree(row);
    }

    public boolean checkBoundAndRowOutput(int column, int row) {
        if (this.board.checkNotInBounds(column, row)) {
            InputOutput.println("The given row is out of bounds. Try again.");
            return false;
        }
        else {
            if (isRowFree(row)) {
                return true;
            }
            else {
                InputOutput.println("The given row is full with pieces. Try again");
                return false;
            }
        }
    }

    private int getNextFreeColumnOfRow(int row) {
        char currentSymbol;
        for (int column = 0; column < board.maxColumn; column++) {
            currentSymbol = this.board.getPieceAt(column, row);
            if (currentSymbol != ' ') {
                return (column - 1);
            }
        }
        return board.maxColumn - 1;
    }

    public boolean isRowFree(int row) {
        return this.board.getPieceAt(0, row) == ' ';
    }
}

package Board;

public class CheckWinFIAL {
    Board board;
    public CheckWinFIAL(Board board) {
        this.board = board;
    }

    public boolean checkWin(int row, char symbol) {
        int column = getColumn(row);
        if (checkHorizontal(column,row,symbol)) return true;
        if (checkVertical(column,row,symbol)) return true;
        if (checkDiagonalIncreasing(column,row,symbol)) return true;
        if (checkDiagonalDecreasing(column,row,symbol)) return true;
        return false;
    }

    public int getColumn(int row) {
        for (int column = 0; column < this.board.maxColumn; column++) {
            if (this.board.getPieceAt(column, row) != ' ')  {
                return column;
            }
        }
        return this.board.maxColumn - 1;
    }
    private boolean checkHorizontal(int column, int row, char symbol) {
        int rightSameSymbol = 0;
        boolean left = false;
        int rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            if (left) {
                rowWithOffset = row - offset + rightSameSymbol;
                if (this.board.checkNotInBounds(column, rowWithOffset)) {
                    return false;
                }
            }
            else  {
                rowWithOffset = row + offset;
                if (this.board.checkNotInBounds(column, rowWithOffset)) {
                    left = true;
                    rowWithOffset = row - offset + rightSameSymbol;
                }
            }
            if (isSameSymbol(column, rowWithOffset, symbol)) {
                if (!left) {
                    rightSameSymbol++;
                }
            } else {
                left = true;
                rowWithOffset = row - offset + rightSameSymbol;
                if (this.board.checkNotInBounds(column, rowWithOffset)) {
                    return false;
                }
                if (!isSameSymbol(column, rowWithOffset, symbol)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkVertical(int column, int row, char symbol) {
        int downSameSymbol = 0;
        boolean up = false;
        int columnWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            if (up) {
                columnWithOffset = column - offset + downSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, row)) {
                    return false;
                }
            }
            else  {
                columnWithOffset = column + offset;
                if (this.board.checkNotInBounds(columnWithOffset, row)) {
                    up = true;
                    columnWithOffset = column - offset + downSameSymbol;
                }
            }
            if (isSameSymbol(columnWithOffset, row, symbol)) {
                if (!up) {
                    downSameSymbol++;
                }
            } else {
                up = true;
                columnWithOffset = column - offset + downSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, row)) {
                    return false;
                }
                if (!isSameSymbol(columnWithOffset, row, symbol)) {
                    return false;
                }
            }
        }
        return true;
    }



    private boolean checkDiagonalIncreasing(int column, int row, char symbol) {
        int upSameSymbol = 0;
        boolean down = false;
        int columnWithOffset;
        int rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            if (down) {
                columnWithOffset = column + offset - upSameSymbol;
                rowWithOffset = row - offset + upSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    return false;
                }
            }
            else  {
                columnWithOffset = column - offset;
                rowWithOffset = row + offset;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    down = true;
                    columnWithOffset = column + offset - upSameSymbol;
                    rowWithOffset = row - offset + upSameSymbol;
                    if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                        return false;
                    }
                }
            }
            if (isSameSymbol(columnWithOffset, rowWithOffset, symbol)) {
                if (!down) {
                    upSameSymbol++;
                }
            } else {
                down = true;
                columnWithOffset = column + offset - upSameSymbol;
                rowWithOffset = row - offset + upSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    return false;
                }
                if (!isSameSymbol(columnWithOffset, rowWithOffset, symbol)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDiagonalDecreasing(int column, int row, char symbol) {
        int upSameSymbol = 0;
        boolean up = false;
        int columnWithOffset;
        int rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            if (up) {
                columnWithOffset = column - offset + upSameSymbol;
                rowWithOffset = row - offset + upSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    return false;
                }
            }
            else  {
                columnWithOffset = column + offset;
                rowWithOffset = row + offset;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    up = true;
                    columnWithOffset = column - offset + upSameSymbol;
                    rowWithOffset = row - offset + upSameSymbol;
                    if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                        return false;
                    }
                }
            }
            if (isSameSymbol(columnWithOffset, rowWithOffset, symbol)) {
                if (!up) {
                    upSameSymbol++;
                }
            } else {
                up = true;
                columnWithOffset = column - offset + upSameSymbol;
                rowWithOffset = row - offset + upSameSymbol;
                if (this.board.checkNotInBounds(columnWithOffset, rowWithOffset)) {
                    return false;
                }
                if (!isSameSymbol(columnWithOffset, rowWithOffset, symbol)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSameSymbol(int column, int row, char symbol) {
        return symbol == this.board.getPieceAt(column, row);
    }

}

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
        int same = 1;
        int rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            rowWithOffset = row + offset;
            if (rowWithOffset > this.board.maxRow - 1) {
                rowWithOffset -= 2*offset;
                if (this.board.getPieceAt(column, rowWithOffset) == symbol) {
                    same++;
                }
                else return false;
            }
            if (this.board.getPieceAt(column, rowWithOffset) == symbol) {
                same++;
            }
            else {
                rowWithOffset-= 2*offset;
                if (rowWithOffset < 0) return false;
                if (this.board.getPieceAt(column, rowWithOffset) == symbol) {
                    same++;}
            }
        }
        return same == 4;
    }

    private boolean checkVertical(int column, int row, char symbol) {
        int same = 1;
        int columnWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            columnWithOffset = column + offset;
            if (columnWithOffset > this.board.maxColumn - 1) {
                columnWithOffset -= 2 * offset;
                if (this.board.getPieceAt(columnWithOffset, row) == symbol) {
                    same++;
                }
                else return false;
            }
            if (this.board.getPieceAt(columnWithOffset, row) == symbol) {
                same++;
            }
            else {
                columnWithOffset -= 2*offset;
                if (columnWithOffset < 0) return false;
                if (this.board.getPieceAt(columnWithOffset, row) == symbol) {
                    same++;
                }
            }
        }
        return same == 4;
    }

    private boolean checkDiagonalIncreasing(int column, int row, char symbol) {
        int same = 1;
        int columnWithOffset, rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            columnWithOffset = column - offset;
            rowWithOffset = row + offset;
            if (columnWithOffset < 0 || rowWithOffset > board.maxRow -1) {
                columnWithOffset += 2*offset;
                rowWithOffset -= 2*offset;
                if (columnWithOffset > board.maxColumn - 1|| rowWithOffset < 0) return false;
                if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                    same++;
                    continue;
                }
                else return false;
            }
            if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                same++;
            }
            else {
                columnWithOffset += 2*offset;
                rowWithOffset -= 2*offset;
                if (columnWithOffset > board.maxColumn - 1|| rowWithOffset < 0) return false;
                if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                    same++;
                }
            }
        }
        return same == 4;
    }

    private boolean checkDiagonalDecreasing(int column, int row, char symbol) {
        int same = 1;
        int columnWithOffset, rowWithOffset;
        for (int offset = 1; offset < 4; offset++) {
            columnWithOffset = column - offset;
            rowWithOffset = row - offset;
            if (columnWithOffset < 0 || rowWithOffset < 0) {
                columnWithOffset += 2*offset;
                rowWithOffset += 2*offset;
                if (columnWithOffset > board.maxColumn - 1 || rowWithOffset > board.maxRow - 1) return false;
                if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                    same++;
                    continue;
                }
                else return false;
            }
            if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                same++;
            }
            else {
                columnWithOffset += 2*offset;
                rowWithOffset += 2*offset;
                if (columnWithOffset > board.maxColumn-1 || rowWithOffset > board.maxRow -1) return false;
                if (this.board.getPieceAt(columnWithOffset, rowWithOffset) == symbol) {
                    same++;
                }
            }
        }
        return same == 4;
    }

}

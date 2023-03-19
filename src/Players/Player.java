package Players;

import Board.BoardManager;

public abstract class Player {
    protected String name;
    protected char pieceSymbol;
    protected BoardManager boardManager;

    public char getPieceSymbol() {
        return pieceSymbol;
    }
    public String getName() {
        return name;
    }

    public abstract void executeMove();
}

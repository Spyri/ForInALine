package Players;

public abstract class Player {
    protected String name;
    protected char pieceSymbol;
    public char getPieceSymbol() {
        return pieceSymbol;
    }
    public String getName() {
        return name;
    }

    public abstract void executeMove();
}

package P3.src;


public class Piece {
    private String color;
    
    public Piece(String color) {
        this.color = color;
    }
    
    /**
     *  get the color of a piece
     * @return the color of a piece
     */
    
    public String getColor() {
        String col = color;
        return col;
    }
    
    /**
     * set the color of a piece
     * @param col color you want to set
     */
    public void setColor(String col) {
        this.color=col;
    }
    
}

class ChessPiece extends Piece{
    //AI:
    // every type in a chess game
    //AF:
    // AF(color,chesstype) = color can choose "white" or "black" and must the same as its player
    //                       chesstype can choose in ChessType
    //fields
    private ChessType chesstype;
    
    //constructor
    public ChessPiece(String color,ChessType chesstype) {
        super(color);
        this.chesstype = chesstype;
    }
    //methods
    public ChessType getChessType(){
        ChessType type = chesstype;
        return type;
    }
    
    public void setChessType(ChessType chesstype) {
        this.chesstype = chesstype;
    }
    
    @Override public String toString() {
        return "ChessPiece:"+super.getColor()+"."+chesstype;
    }
}

class GoPiece extends Piece{
    
    //RI:
    // color the player's color
    //AF:
    // AF(color)= color can choose "white" or "black" and must the same as its player
    //constructor
    public GoPiece(String color) {
        super(color);
    }
    
    //override toString
    @Override public String toString() {
        return "GoPiece:"+super.getColor();
    }
}
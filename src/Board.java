package P3.src;


/*
 * Board - A abstract class to implement a Chess or Go board data structure.
 */

abstract public class Board {
    public abstract void CreatNewBoard();
}

/*
 * GoBoard - a board needs in a go game.
 * At the beginning , the board is null
 * you can choose place , kill , check on this board
 */
class GoBoard extends Board {

    final int size = 19; //cross point of GoGame 
    public GoPiece goBoard[][] = new GoPiece[size][size]; 
    /*
     * create a goBoard
     */
    public void CreatNewBoard() {

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                goBoard[i][j]=null;
            }
        }
    }
    
}

/*
 * ChessBoard - a board needs in a chess game.
 * At the beginning , the board is created by players and the pieces is in its position.
 * you can choose move , eat , check on this board
 */

class ChessBoard extends Board  {
    /*
     * init a chessBoard
     */
    
    final int size = 8; //cross point of ChessGame
    public ChessPiece chessBoard[][] = new ChessPiece[size][size];
    /*
     * create a chessBoard
     */
    public void CreatNewBoard() {
        
        chessBoard[0][0] = new ChessPiece("white",ChessType.rook);
        chessBoard[1][0] = new ChessPiece("white",ChessType.knight);
        chessBoard[2][0] = new ChessPiece("white",ChessType.bishop);
        chessBoard[3][0] = new ChessPiece("white",ChessType.queen);
        chessBoard[4][0] = new ChessPiece("white",ChessType.king);
        chessBoard[5][0] = new ChessPiece("white",ChessType.bishop);
        chessBoard[6][0] = new ChessPiece("white",ChessType.knight);
        chessBoard[7][0] = new ChessPiece("white",ChessType.rook);
        for(int i=0;i<size;i++) {
            chessBoard[i][1] = new ChessPiece("white",ChessType.pawn);
        }
        
        chessBoard[0][7] = new ChessPiece("black",ChessType.rook);
        chessBoard[1][7] = new ChessPiece("black",ChessType.knight);
        chessBoard[2][7] = new ChessPiece("black",ChessType.bishop);
        chessBoard[3][7] = new ChessPiece("black",ChessType.queen);
        chessBoard[4][7] = new ChessPiece("black",ChessType.king);
        chessBoard[5][7] = new ChessPiece("black",ChessType.bishop);
        chessBoard[6][7] = new ChessPiece("black",ChessType.knight);
        chessBoard[7][7] = new ChessPiece("black",ChessType.rook);
        for(int i=0;i<size;i++) {
            chessBoard[i][6] = new ChessPiece("black",ChessType.pawn);
        }
        
    }

}


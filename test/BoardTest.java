package P3.src;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //test GoBoard
    @Test
    public void testGoBoard() {
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        for(int i=0;i<19;i++) {
            for(int j=0;j<19;j++) {
                assertEquals(null,goboard.goBoard[i][j]);
            }
        }

    }
    
    //test ChessBoard
    @Test
    public void testChessBoard() {
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        assertEquals(ChessType.king,chessboard.chessBoard[4][7].getChessType());
        assertEquals(ChessType.pawn,chessboard.chessBoard[4][1].getChessType());
        assertEquals("white",chessboard.chessBoard[0][0].getColor());
        assertEquals("black",chessboard.chessBoard[0][7].getColor());
    }
}

package P3.src;

import static org.junit.Assert.*;
import org.junit.Test;

public class PieceTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //test methods in class GoPiece 
    @Test
    public void testGoPiece() {
        GoPiece go1= new GoPiece("white");
        assertEquals("white",go1.getColor());
        String go = "GoPiece:white";
        assertEquals(go,go1.toString());
    }
    
  //test methods in class ChessPiece 
    @Test
    public void testChessPiece() {
        ChessPiece chess1 = new ChessPiece("black",ChessType.queen);
        ChessPiece chess2 = new ChessPiece("white",ChessType.king);
        assertEquals(chess1.getChessType(),ChessType.queen);
        assertEquals(chess2.getColor(),"white");
    }
}

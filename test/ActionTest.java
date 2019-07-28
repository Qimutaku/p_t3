package P3.src;

import static org.junit.Assert.*;
import org.junit.Test;

public class ActionTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    //test methods in ChessAction
    @Test
    public void  testMove() {
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        Player p = new Player("li","white");
        ChessAction chessaction = new ChessAction();
        Position po1 = new Position(2,1);
        Position po2 = new Position(3,4);
        assertTrue(chessaction.isMoveable(chessboard, po1, po2, p));
        chessaction.move(chessboard, po1, po2);
        assertFalse(chessaction.isMoveable(chessboard, po1, po2, p));
        
    }
    
    @Test
    public void testEat() {
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        Player p = new Player("li","white");
        ChessAction chessaction = new ChessAction();
        Position po1 = new Position(2,1);
        Position po2 = new Position(2,7);
        assertTrue(chessaction.isEatable(chessboard, po1, po2, p));
        chessaction.eat(chessboard, po1, po2);
        assertFalse(chessaction.isEatable(chessboard, po1, po2, p));
        
    }
    
    @Test
    public void testObserve() {
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        Player p = new Player("li","white");
        Position po1 = new Position(2,1);
        Position po2 = new Position(3,4);
        ChessAction chessaction = new ChessAction();
        assertTrue(chessaction.isMoveable(chessboard, po1, po2, p));
        chessaction.observe(chessboard, po1);
        chessaction.move(chessboard, po1, po2);
        chessaction.observe(chessboard, po1);
    }
    
    @Test
    public void testIsMoveable() {
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        Player p = new Player("li","white");
        ChessAction chessaction = new ChessAction();
        Position po1 = new Position(2,1);
        Position po2 = new Position(3,4);
        assertTrue(chessaction.isMoveable(chessboard, po1, po2, p));
        chessaction.move(chessboard, po1, po2);
        assertFalse(chessaction.isMoveable(chessboard, po1, po2, p));
        Position po3 = new Position(8,8);
        assertFalse(chessaction.isMoveable(chessboard, po1, po3, p));
        
    }
    
    @Test
    public void testIsEatable() {
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        Player p = new Player("li","white");
        ChessAction chessaction = new ChessAction();
        Position po1 = new Position(2,1);
        Position po2 = new Position(2,7);
        assertTrue(chessaction.isEatable(chessboard, po1, po2, p));
        chessaction.eat(chessboard, po1, po2);
        assertFalse(chessaction.isEatable(chessboard, po1, po2, p));
        
    }
    
    
    //test methods in GoAction
    @Test
    public void testPlace() {
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        GoAction goaction = new GoAction();
        Position po1 = new Position(2,1);
        assertTrue(goaction.isPlaceable(goboard, po1));
        goaction.place(goboard, po1, "white");
        assertFalse(goaction.isPlaceable(goboard, po1));
        
    }
    
    @Test
    public void testKill() {
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        GoAction goaction = new GoAction();
        Position po1 = new Position(2,5);
        Position po2 = new Position(2,6);
        Position po3 = new Position(2,7);
        Position po4 = new Position(3,5);
        Position po5 = new Position(3,6);
        Position po6 = new Position(3,7);
        Position po7 = new Position(4,5);
        Position po8 = new Position(4,6);
        Position po9 = new Position(4,7);
        goaction.place(goboard, po1, "white");
        goaction.place(goboard, po2, "white");
        goaction.place(goboard, po3, "white");
        goaction.place(goboard, po4, "white");
        goaction.place(goboard, po6, "white");
        goaction.place(goboard, po7, "white");
        goaction.place(goboard, po8, "white");
        goaction.place(goboard, po9, "white");
        goaction.place(goboard, po5, "black");
        assertFalse(goaction.isPlaceable(goboard, po5));
        goaction.kill(goboard);
        assertTrue(goaction.isPlaceable(goboard, po5));
    }
    
    @Test
    public void testobserve() {
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        GoAction goaction = new GoAction();
        Position po1 = new Position(2,1);
        goaction.observe(goboard, po1);
        goaction.place(goboard, po1, "white");
        goaction.observe(goboard, po1);
    }
    
    @Test
    public void testIsPlaceable() {
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        GoAction goaction = new GoAction();
        Position po1 = new Position(2,1);
        assertTrue(goaction.isPlaceable(goboard, po1));
        goaction.place(goboard, po1, "white");
        assertFalse(goaction.isPlaceable(goboard, po1));
        Position po2 = new Position(19,0);
        assertFalse(goaction.isPlaceable(goboard, po2));
    }
}

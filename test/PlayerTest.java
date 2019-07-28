package P3.src;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //test method:getName() && getColor()
    @Test
    public void testGet() {
        Player player1 = new Player("Amy","white");
        Player player2 = new Player("Sam","black");
        assertEquals("Amy",player1.getName());
        assertEquals("Sam",player2.getName());
        assertEquals("white",player1.getColor());
        assertEquals("black",player2.getColor());
    }
}

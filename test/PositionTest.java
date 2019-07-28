package P3.src;

import static org.junit.Assert.*;
import org.junit.Test;

public class PositionTest {
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    //test method:getX() && getY()
    @Test 
    public void tesGet() {
        Position po = new Position(3,4);
        assertEquals(3,po.getX());
        assertEquals(4,po.getY());        
    }
    
    //test override method: Equals()
    @Test 
    public void testEquals() {
        Position po1 = new Position(2,5);
        Position po2 = new Position(2,5);
        Position po3 = new Position(3,4);
        assertEquals(po1.hashCode(),po2.hashCode());
        assertTrue(po1.equals(po2));
        assertFalse(po1.equals(po3));
        
    }
}

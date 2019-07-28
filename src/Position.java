package P3.src;

/**
 * show the position of piece on the board. 
 *
 */

public class Position {
    
    //AF:
    //  AF(x,y) = coordinates of a piece
    //RI:
    // coordinates cannot out of the board
    
    //fields
    private int x,y;
    
    // constructor
    /**
     * 
     * @param x abscissa of the pieve
     * @param y ordinate of the piece
     */
    public Position(int x,int y) {
        this.x = x;
        this.y = y;
    }
    
    // methods
    /**
     * 
     * @return the abscissa of a piece
     */
    public int getX() {
        int X = x;
        return X;
    }
    
    /**
     * 
     * @return the ordinate of a piece
     */
    public int getY() {
        int Y = y;
        return Y;
    }
    
    // override toString
    @Override public String toString() {
        return "Position:("+x+","+y+")";
    }
    
    @Override public int hashCode() {
        final int result = 1;
        int hash = result * 31 + x;
        hash = result * 31 + y;
        return hash;        
    }
    
    
    //override equals()
    @Override public boolean equals(Object obj) {
        if(!(obj instanceof Position)) return false;
        Position po = (Position) obj;
        return (x== po.getX()) && (y == po.getY());
    }
}

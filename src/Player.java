package P3.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * show the player in chess or go game.
 *
 */
public class Player {
    //RI:
    //name:represent a player's name
    //color:represents a player's color
    //AF:
    // AF(name,color) = the player in a game(chess or go),color can choose "black" or "white", everyone has his own name.
    private String name;
    private String color;
    
    
    // constructor
    /**
     * 
     * @param name a player's name
     * @param color a player's color
     */
    public Player(String name,String color) {
        this.color = color;
        this.name = name;
    }
    
    //methods
    /**
     * 
     * @return the player's name
     */
    public String getName() {
        String it = name;
        return it;
    }
    
    /**
     * 
     * @return the player's color
     */
    public String getColor() {
        String col = color;
        return col;
    }
    
    /*
     * Record the position that the player walks.
     */
    List<Position> record = new ArrayList<>();
}

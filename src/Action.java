package P3.src;

/*
 * Action - A abstract class for implementing a Chess or Go action.
 */
public class Action {
    //check a position: has a piece or not.
    //if has, which piece is in the position.
    public void observe() {
    }
    
}

/*
 *  chess action:include move,eat,observe
 *  move():check if you can move a piece
 *  eat():check if you can eat pieces
 *  observe():check for chess pieces in a position
 *  You have to decide whether you can do it or not first,include methods:
 *  isMoveable(),isEatable()
 */

class ChessAction extends Action{
    
    /**
     * you can move from source to target
     * @param board a chessboard you can have an action on
     * @param source where you move from
     * @param target where you move to
     */
    public void move(ChessBoard board,Position source,Position target) {
        System.out.println(board.chessBoard[source.getX()][source.getY()].toString() + 
                " will move from "+ source.toString()+" to " + target.toString());
        board.chessBoard[target.getX()][target.getY()]= board.chessBoard[source.getX()][source.getY()];
        board.chessBoard[source.getX()][source.getY()] = null;
    }
    
    /**
     * you can eat a chess piece if target has a piece which belongs to your rival
     * @param board a chessboard you can have an action on
     * @param source where you move from
     * @param target where you want to eat a piece
     */
    public void eat(ChessBoard board,Position source,Position target) {
        System.out.println(board.chessBoard[target.getX()][target.getY()].toString()+
                " at "+target.toString()+" will eat by "+
                board.chessBoard[source.getX()][source.getY()].toString()+" at "+ source.toString());
        board.chessBoard[target.getX()][target.getY()]= board.chessBoard[source.getX()][source.getY()];
        board.chessBoard[source.getX()][source.getY()] = null;
    }
    
    /**
     * check if there is a piece in special position
     * if it has,output its information
     * else,output null.
     * @param board
     * @param po
     */
    public void observe(ChessBoard board,Position po) {
        if(board.chessBoard[po.getX()][po.getY()]!=null) {
            System.out.println("Piece at "+po.toString()+" is "+board.chessBoard[po.getX()][po.getY()].toString());  
        }

        else {
           System.out.println("There is no piece in the position."); 
        }
    }
    
    /**
     * Determine if you can move.The following cannot be moved:
     * position out of board,source and target are the same position,
     * the source doesn't have a piece or the target has a piece,
     * the source piece doesn't belong to player,
     * the target piece belongs to player.
     * @param chessboard you play a chessgame on it
     * @param source where you move from
     * @param target where you move to
     * @param p who take this action
     * @return true if you can move 
     */
    public boolean isMoveable(ChessBoard chessboard,Position source,Position target,Player p) {
            
        //position out of board
        if(source.getX()<0 || source.getY()<0 || source.getX()>7 || source.getX()>7 ) {
            System.out.println("the source is out of board!");
            return false;
        }
            
        if(target.getX()<0 || target.getY()<0 || target.getX()>7 || target.getY()>7) {
            System.out.println("the terget is out of board!");
            return false;
        }
        
        //source and target are the same position
        if(source.getX()==target.getX() && source.getY()==target.getY())  {
             System.out.println("the source and the taregt are the same position!");
             return false;
         }  
        
        //the source doesn't have a piece
        if(chessboard.chessBoard[source.getX()][source.getY()]==null)  {
            System.out.println("the source doesn't have a piece!");
            return false;
        }
        
        //the target already has a piece
        if(chessboard.chessBoard[target.getX()][target.getY()]!=null) {
            System.out.println("the target already has a piece!");
            return false;
        }            
        
        //if the piece doesn't belong to this player
        if(!chessboard.chessBoard[source.getX()][source.getY()].getColor().equals(p.getColor())) {
            System.out.println("the piece belongs to another player!");
            return false;
        }

         return true;
    }
    
    /**
     * Determine if you can eat.The following cannot be eated:
     * position out of board,source and target are the same position,
     * the source or target doesn't have a piece,
     * the source piece doesn't belong to player,
     * the target piece belongs to player.
     * @param chessboard chessboard you play a chessgame on it
     * @param source position you eat from
     * @param target position you eat to
     * @param p player who take this action
     * @return true if you can eat
     */
    public boolean isEatable(ChessBoard chessboard,Position source,Position target,Player p) {
        //position out of board
        if(source.getX()<0 || source.getY()<0 || source.getX()>7 || source.getX()>7 ) {
            System.out.println("the source is out of board!");
            return false;
        }
            
        if(target.getX()<0 || target.getY()<0 || target.getX()>7 || target.getY()>7) {
            System.out.println("the terget is out of board!");
            return false;
        }
        
        //source and target are the same position
        if(source.getX()==target.getX() && source.getY()==target.getY())  {
             System.out.println("the source and the taregt are the same position!");
             return false;
         }
        
        //the source doesn't have a piece
        if(chessboard.chessBoard[source.getX()][source.getY()]==null)  {
            System.out.println("the source doesn't have a piece!");
            return false;
        }
        
        //the target doesn't have a piece
        if(chessboard.chessBoard[target.getX()][target.getY()]==null) {
            System.out.println("the target doesn't have a piece!");
            return false;
        }
        
        //if the source piece doesn't belong to this player
        if(!chessboard.chessBoard[source.getX()][source.getY()].getColor().equals(p.getColor())) {
            System.out.println("the source piece belongs to another player!");
            return false;
        }
        
        //the target piece belongs to this player
        if(chessboard.chessBoard[target.getX()][target.getY()].getColor().equals(p.getColor())) {
            System.out.println("the target piece belongs to you!");
            return false;
        }
        
        //if the target piece belongs to this player
        if(chessboard.chessBoard[target.getX()][target.getY()]!=null && 
                chessboard.chessBoard[target.getX()][target.getY()].getColor().equals(p.getColor())) {
            System.out.println("the target piece belongs to you!");
            return false;
        }
        
        return true;
    }
    
}


/*
 *  go action:include place,kill,observe
 *  place():check if you can place a piece
 *  kill():check if you can have pieces to kill
 *  observe():check for go pieces in a position
 *  You have to decide whether you can do it or not first,include method:
 *  isPlaceble()
 */
class GoAction extends Action{
    
    public void place(GoBoard board,Position po,String col) {
        
        board.goBoard[po.getX()][po.getY()]=new GoPiece(col);
        
    }
    
    /*
     * "Qi" you can simply understand whether there is a vacancy around a single particle, 
     * and if there is no vacancy, 
     * it includes the square around or has reached the edge, 
     * which has become the basis for judging whether a particle can be formed.
     * We call these connected pieces "block",
     * because they are pieces of the same color.
     * We define the concept of eating sub as: 
     * if the "block" has no "qi", it can be mentioned, that is, eating sub.
     */
    int[] block;  //records the size of a block as a temporary variable
    int blockLength = 0; // record the length of this block
    
    /*
     * If no chess pieces are found at this position, skip this loop to detect the next position.
     * If there are chessmen, define an int array of 19*19=361 space called block, 
     * and update the blockLength of the corresponding block to 1.
     */
    public void kill(GoBoard board) {
        for(int i=0;i<19;i++) {
            for(int j=0;j<19;j++) {
                if(board.goBoard[i][j]==null) {
                    continue;
                }
                else {
                    block = new int[19*19];
                    blockLength = 1;
                    block[0] = i*100 +j;
                    
                    recursion(board,i,j);
                    
                    if(!hasQi(board))
                        continue;
                    else {
                        for(int t=0;t<blockLength;t++) {
                            System.out.println("("+block[t]/100+","+block[t]%100+")"+board.goBoard[block[t]/100][block[t]%100].toString() + " is eaten.");
                            board.goBoard[block[t]/100][block[t]%100]=null;
                        }
                    }
                }
            }
        }
    }
    // go around the pieces
    /**
     * recursively calls until all the pieces 
     * with the same color as the pieces at the coordinate (I,j) are traversed 
     * and recorded in the array of blocks one by one.
     * @param board a goboard you play on
     * @param i the coordinate value of the piece
     * @param j the coordinate value of the piece
     */
    public void recursion(GoBoard board,int i,int j) {
        //left
        if(i-1>=0 && board.goBoard[i-1][j] ==board.goBoard[i][j] && isInBlock((i-1)*100+j)) {
            block[blockLength]=(i-1)*100+j;
            blockLength++;
            recursion(board,i-1,j);
        }
        
        //up
        if(j-1>=0 && board.goBoard[i][j-1]==board.goBoard[i][j] && isInBlock(i*100+j-1)) {
            block[blockLength] = i*100+j-1;
            blockLength++;
            recursion(board,i,j-1);
        }
        
        //right
        if(i+1<19 && board.goBoard[i+1][j]==board.goBoard[i][j] && isInBlock((i+1)*100+j)) {
            block[blockLength] = (i+1)*100+j;
            blockLength++;
            recursion(board,i+1,j);
        }
        
        //down
        if(j+1<19 && board.goBoard[i][j+1]==board.goBoard[i][j] && isInBlock(i*100+j+1)) {
            block[blockLength] = i*100+j+1;
            blockLength++;
            recursion(board,i,j+1);
        }
        
    }
    
    /**
     * If the block is airless, that is, it meets the requirements of the raison, 
     * then the value of the corresponding position of these children in map[][] is set to 0.
     * @return true if the block is alive, and this function.
     */
    public boolean hasQi(GoBoard board) {
        int i,j;
        for(int t=0;t<blockLength;t++) {
            i = block[t]/100;
            j = block[t]%100;
            if(i-1 >= 0 && board.goBoard[i-1][j] == null)
                return false;
            if(j-1 >= 0 && board.goBoard[i][j-1] == null)
                return false;
            if(i+1 < 19 && board.goBoard[i+1][j] == null)
                return false;
            if(j+1 < 19 && board.goBoard[i][j+1] == null)
                return false;
        }
        return true;
    }
    
    /**
     * determine whether a round piece has been traversed.
     * @param s  the piece's place in block
     * @return true if a round piece has been traversed.
     */
    public boolean isInBlock(int s) {
        for(int i=0;i<blockLength;i++) {
            if(block[i]==s)
                return false;
        }
        return true;
    }
    
    /**
     * check if there is a piece in special position
     * if it has,output its information
     * else,output null.
     * @param board a goboard for your action
     * @param po the position you want to check
     */
    public void observe(GoBoard board,Position po) {
        if(board.goBoard[po.getX()][po.getY()]!=null) {
            System.out.println("Piece at "+po.toString()+" is "+board.goBoard[po.getX()][po.getY()].toString());
        }
        else {
            System.out.println("There is no piece in the position."); 
        }
   
    }
    
    /**
     * Determine if you can place.The following cannot be moved:
     * position out of board,the position has a piece.
     * @param board a goboard for your action
     * @param po position you are ready to place a piece
     * @return true if you can place a piece
     */
    public boolean isPlaceable(GoBoard board,Position po) {
        
        //position out of board
        if(po.getX()<0 || po.getY()<0 || po.getX()>18 || po.getY()>18) {
            System.out.println("the position is out of board!");
            return false;
        }
        
        //the position already has a piece
        if(board.goBoard[po.getX()][po.getY()]!=null) {
            System.out.println("the position already has a piece!");
            return false;
        }
        
        return true;
    }
}

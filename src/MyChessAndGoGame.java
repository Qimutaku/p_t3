package P3.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MyChessAndGoGame {
    
    /*
     * the user is given the option to create a chess or a go game, 
     * and the user enters "1.chess" or "2.go".
     */
    public static void main(String[] args) {

        MyChessAndGoGame mygame = new MyChessAndGoGame();

        if(args[0].equals("chess"))
        {
            mygame.chessgame();
        }
        else if(args[0].equals("go")){
            mygame.gogame();
        }
        else {
            System.out.println("Do a wrong choice!");
            System.exit(-1);
        }

    }
    
    /*
     * in a chess game, you need to input two players' name,
     * they are required to be different.
     * when begins,
     * you have four choose of action:
     * 1.move a piece
     * 2.eat a piece
     * 3.check a position's information
     * 4. calculate the number of pieces
     * you can also input "end" to end the game
     * In the end, we will give the player's position history
     * and calculate the number of pieces left on the board.
     * whose number of pieces is more,he is the winner! 
     */
    public void chessgame() {
        
        System.out.println("Enter player1's name(player1 is white):");
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        Player player1 = new Player(name1,"white");
        System.out.println("Enter player2's name(player2 is black):");
        String name2 = scan.nextLine();
        while(name2.equals(name1)){
            System.out.println("Every player has his own name!");
            System.out.println("Enter player2's name(player2 is black):");
            name2 = scan.nextLine();
        }
        Player player2 = new Player(name2,"black");
        
        ChessBoard chessboard = new ChessBoard();
        chessboard.CreatNewBoard();
        ChessAction chessaction = new ChessAction();

        List<Player> player = new ArrayList<>();
        player.add(player1);
        player.add(player2);
        System.out.println("Start!");
        String order;
        int i = 0;
        boolean flag = true;
        while(flag) {
            for(Player p : player) {
                System.out.printf("It's turn to player%d\n",i%2+1);
                System.out.println("Select an action:");
                System.out.println("1.move chess");
                System.out.println("2.eat chess");
                System.out.println("3.check the position");
                System.out.println("4.Calculate the number of chess");
                System.out.println("end:End the game!");
                order = scan.nextLine();
                if(order.equals("end")) {
                    flag = false;
                    break;
                }
                String[] so;
                String[] ta;
                String s;
                String t;
                switch(order){
                    case "1":
                        while(true)
                        {
                            System.out.println("Input your source(x,y)");
                            s = scan.nextLine();
                            so = s.split(",");
                            System.out.println("Input your target(x,y)");
                            t = scan.nextLine();
                            ta = t.split(",");
                            Position source = new Position(Integer.parseInt(so[0]),Integer.parseInt(so[1]));
                            Position target = new Position(Integer.parseInt(ta[0]),Integer.parseInt(ta[1]));
                            if(chessaction.isMoveable(chessboard,source,target,p)) {
                                chessaction.move(chessboard, source, target);
                                p.record.add(source);
                                p.record.add(target);
                                break;
                            }
                            else {
                                System.out.println("Illegal input! Try Again!");
                            }                                                        
                        }
                        break;
                    case "2":
                        while(true)
                        {
                            System.out.println("Input your source(x,y)");
                            s = scan.nextLine();
                            so = s.split(",");
                            System.out.println("Input your target(x,y)");
                            t = scan.nextLine();
                            ta = t.split(",");
                            Position source = new Position(Integer.parseInt(so[0]),Integer.parseInt(so[1]));
                            Position target = new Position(Integer.parseInt(ta[0]),Integer.parseInt(ta[1]));
                            if(chessaction.isEatable(chessboard,source,target,p)) {
                                chessaction.eat(chessboard, source, target);
                                p.record.add(source);
                                p.record.add(target);
                                break;
                            }
                            else {
                                System.out.println("Illegal input! Try Again!");
                            }                                                        
                        }
                        break;
                    case "3":
                        System.out.println("Input your taregt(x,y):");
                        t = scan.nextLine();
                        ta = t.split(",");
                        Position target = new Position(Integer.parseInt(ta[0]),Integer.parseInt(ta[1]));
                        chessaction.observe(chessboard, target);
                        break;
                    case "4":
                        int num1 = 0;
                        int num2 = 0;
                        for(int j=0;j<8;j++) {
                            for(int k=0;k<8;k++) {
                                if(chessboard.chessBoard[j][k]!=null) {
                                    if(chessboard.chessBoard[j][k].getColor().equals(player1.getColor()))
                                        num1++;
                                    else
                                        num2++;
                                }
                            }
                        }
                        System.out.println("Player1 has "+num1+ " pieces left on the board.");
                        System.out.println("Player2 has "+num2+ " pieces left on the board.");
                        break;
                   default:
                       break;
                }
                i++;               
            }
        }
        System.out.println("Player1 position record:");
        Iterator<Position> iterator1=player1.record.iterator();
        while (iterator1.hasNext()) {
            System.out.println("from:"+iterator1.next().toString()+
                    " to:"+iterator1.next().toString());
        }
        System.out.println("Player2 position record:");
        Iterator<Position> iterator2=player2.record.iterator();
        while (iterator2.hasNext()) {
            System.out.println("from:"+iterator2.next().toString()+
                    " to:"+iterator2.next().toString());
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for(int j=0;j<8;j++) {
            for(int k=0;k<8;k++) {
                if(chessboard.chessBoard[j][k]!=null) {
                    if(chessboard.chessBoard[j][k].getColor().equals(player1.getColor()))
                        sum1++;
                    else
                        sum2++;
                }
            }
        }
        System.out.println("Player1 has "+sum1+ " pieces left on the board.");
        System.out.println("Player2 has "+sum2+ " pieces left on the board.");
        if(sum1>sum2) {
            System.out.println("Player1 win!");
        }
        else if(sum2>sum1) {
            System.out.println("Player2 win!");
        }
        else {
            System.out.println("Tie!");
        }
        
    }
    
    /*
     * in a go game, you need to input two players' name,
     * they are required to be different.
     * when begins,
     * you have four choices of action:2
     * 1.place a piece
     * 2.check a position's information
     * 3.kill pieces
     * 4. calculate the number of pieces
     * you can also input "end" to end the game
     * In the end, we will give the player's position history
     * and calculate the number of pieces left on the board.
     * whose number of pi1eces is more,he is the winner!
     */
    
    public void gogame() {
        
        System.out.println("Enter player1's name:(player1 is white):");
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        Player player1 = new Player(name1,"white");
        System.out.println("Enter player2's name(player2 is black):");
        String name2 = scan.nextLine();
        while(name2.equals(name1)){
            System.out.println("Every player has his own name!");
            System.out.println("Enter player2's name(player2 is black):");
            name2 = scan.nextLine();
        }
        Player player2 = new Player(name2,"black");
        GoBoard goboard = new GoBoard();
        goboard.CreatNewBoard();
        GoAction goaction = new GoAction();
        
        List<Player> player = new ArrayList<>();
        player.add(player1);
        player.add(player2);
        System.out.println("Start!");
        String order;
        int i = 0;
        boolean flag = true;
        while(flag) {
            for(Player p : player) {
                System.out.printf("It's turn to player%d\n",i%2+1);
                System.out.println("Select an action:");
                System.out.println("1.place go");
                System.out.println("2.check the position");
                System.out.println("3.kill");
                System.out.println("4.Calculate the number of go");
                System.out.println("end:End the game!");
                order = scan.nextLine();
                if(order.equals("end")) {
                    flag = false;
                    break;
                }
                String po;
                String[] Po;
                switch(order) {
                case "1":
                    System.out.println("Input your taregt(x,y):");
                    po = scan.nextLine();
                    Po = po.split(",");
                    Position target = new Position(Integer.parseInt(Po[0]),Integer.parseInt(Po[1]));
                    if(goaction.isPlaceable(goboard, target)) {
                        goaction.place(goboard, target, p.getColor());
                        p.record.add(target);
                    }                    
                    break;
                case "2":
                    System.out.println("Input your taregt(x,y):");
                    po = scan.nextLine();
                    Po = po.split(",");
                    Position position= new Position(Integer.parseInt(Po[0]),Integer.parseInt(Po[1]));
                    goaction.observe(goboard, position);
                    break;
                case "3":
                    goaction.kill(goboard);
                    break;
                case "4":
                    int num1 = 0;
                    int num2 = 0;
                    for(int j=0;j<19;j++) {
                        for(int k=0;k<19;k++) {
                            if(goboard.goBoard[j][k]!=null) {
                                if(goboard.goBoard[j][k].getColor().equals(player1.getColor()))
                                    num1++;
                                else
                                    num2++;
                            }
                        }
                    }
                    System.out.println("Player1 has "+num1+ " pieces left on the board.");
                    System.out.println("Player2 has "+num2+ " pieces left on the board.");
                    break;
                default :
                    break;
                }
                i++;
            }

        }
        System.out.println("Player1 position record:");
        Iterator<Position> iterator1=player1.record.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }
        System.out.println("Player2 position record:");
        Iterator<Position> iterator2=player2.record.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for(int j=0;j<19;j++) {
            for(int k=0;k<19;k++) {
                if(goboard.goBoard[j][k]!=null) {
                    if(goboard.goBoard[j][k].getColor().equals(player1.getColor()))
                        sum1++;
                    else
                        sum2++;
                }
            }
        }
        System.out.println("Player1 has "+sum1+ " pieces left on the board.");
        System.out.println("Player2 has "+sum2+ " pieces left on the board.");
        if(sum1>sum2) {
            System.out.println("Player1 win!");
        }
        else if(sum2>sum1) {
            System.out.println("Player2 win!");
        }
        else {
            System.out.println("Tie!");
        }
    }
}

package day02;


import java.io.FileInputStream;
import java.util.Scanner;

public class Part1 {
    private final static int[] gameResults = {0,3,6};
    public static void main(String[] args){
        int accScore = 0;
        try(Scanner s = new Scanner(new FileInputStream("src/day02/strategy.txt"))){
            while(s.hasNextLine()){
                String[] moves = s.nextLine().split(" ");
                accScore += eval(moves[0],moves[1]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Accumulated score for following strategy.txt: "+accScore);
    }

    private static int eval(String a, String b){
        int moveValue = 0;
        Moves opponentMove = evalMove(a);
        Moves myMove = evalMove(b);
        switch(myMove){
            case ROCK:{
                moveValue += 1;
                break;
            }
            case PAPER:{
                moveValue += 2;
                break;
            }
            case SCISSORS:{
                moveValue += 3;
                break;
            }
            default: return 0;
        }
        moveValue += gameResults[(myMove.id+4-opponentMove.id) % 3]; //avoid the funny with the modulo in java when the result goes negative
        return moveValue;
    }
    private static Moves evalMove(String s){
        if(s.equals("A") || s.equals("X"))
            return Moves.ROCK;
        else if(s.equals("B") || s.equals("Y")){
            return Moves.PAPER;
        } else if(s.equals("C") || s.equals("Z"))
            return Moves.SCISSORS;
        return null;
    }
    private enum Moves{
        ROCK(0),
        PAPER(1),
        SCISSORS(2)
        ;
        public final int id;
        Moves(int i){this.id = i;}
    }
}
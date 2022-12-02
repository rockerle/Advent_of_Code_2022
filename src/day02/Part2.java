package day02;

import java.io.FileInputStream;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args){
        int accScore = 0;
        try(Scanner s = new Scanner(new FileInputStream("src/day02/strategy.txt"))){
            while(s.hasNextLine()){
                String[] line = s.nextLine().split(" ");
                accScore += evalResult(evalMove(line[0]), line[1]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Accumulated Score according to the strategy: "+accScore);
    }
    private static int evalResult(Moves a, String b){
        switch(b){
            case "X":{ //lose case
                return ((a.id+2)%3)+1;
            }
            case "Y":{ // draw case
                return a.id+1 + 3;
            }
            case "Z":{ // win case
                return ((a.id+1)%3)+1 + 6;
            }
            default: return 0;
        }
    }
    private static Moves evalMove(String s){
        if(s.equals("A"))
            return Moves.ROCK;
        else if(s.equals("B")){
            return Moves.PAPER;
        } else if(s.equals("C"))
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
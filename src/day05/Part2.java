package day05;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Part2 {

    private static Stack<Character>[] stacks = new Stack[9];

    public static void main(String[] args){
        init();
        try(Scanner s = new Scanner(new FileInputStream("src/day05/input.txt"))){
            while(s.hasNextLine()){
                String[] moveOrder = s.nextLine().split(" ");
                move(Integer.parseInt(moveOrder[3])-1,Integer.parseInt(moveOrder[5])-1,Integer.parseInt(moveOrder[1]));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Peeking the top of the stacks");
        System.out.println("=============================");
        for (Stack<Character> stack : stacks) {
            System.out.print(stack.isEmpty()?" ":stack.peek() + "");
        }
        System.out.print(System.lineSeparator());
        System.out.println("=============================");
    }

    private static void move(int from, int to, int amount){
        System.out.println("moving "+amount+" of boxes from "+from+" to "+to);
       Stack<Character> tempStack = new Stack<>();
       for(int i=0;i<amount;i++){
           tempStack.push(stacks[from].pop());
       }
       for(int i=0;i<amount;i++){
            stacks[to].push(tempStack.pop());
       }
    }

    private static void init(){
        for (int i=0;i<stacks.length;i++) {
            stacks[i] = new Stack<>();
        }
        for (StacksStartConfig value : StacksStartConfig.values()) {
            stacks[value.ordinal()].addAll(value.letters.chars().mapToObj(c->(char)c).collect(Collectors.toList()));
        }
    }
//Initial Configuration of the stacks
//[P]     [C]         [M]
//[D]     [P] [B]     [V] [S]
//[Q] [V] [R] [V]     [G] [B]
//[R] [W] [G] [J]     [T] [M]     [V]
//[V] [Q] [Q] [F] [C] [N] [V]     [W]
//[B] [Z] [Z] [H] [L] [P] [L] [J] [N]
//[H] [D] [L] [D] [W] [R] [R] [P] [C]
//[F] [L] [H] [R] [Z] [J] [J] [D] [D]
// 1   2   3   4   5   6   7   8   9
    private enum StacksStartConfig{
        ONE("FHBVRQDP"),
        TWO("LDZQWV"),
        THREE("HLZQGRPC"),
        FOUR("RDHFJVB"),
        FIVE("ZWLC"),
        SIX("JRPNTGVM"),
        SEVEN("JRLVMBS"),
        EIGHT("DPJ"),
        NINE("DCNWV");
        private final String letters;
        StacksStartConfig(String s){this.letters = s;}
    }
}
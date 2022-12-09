package day05;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Part1 {

    private static Stack<Character>[] stacks = new Stack[9];

    public static void main(String[] args){
        initStacks();
        try(Scanner s = new Scanner(new FileInputStream("src/day05/input.txt"))){
            while(s.hasNextLine()){
                String[] prompt = s.nextLine().split(" ");
                System.out.println("preparing move "+ Integer.parseInt(prompt[1]) +" times from "+Integer.parseInt(prompt[3])+" to "+Integer.parseInt(prompt[5]));
                move(Integer.parseInt(prompt[3])-1,Integer.parseInt(prompt[5])-1,Integer.parseInt(prompt[1]));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Peeking the top of the stacks");
        System.out.println("=============================");
        for (Stack<Character> stack : stacks) {
            System.out.print(stack.isEmpty()?" ":stack.peek() + "");
        }
        System.out.println("=============================");
    }

    private static void move(int from, int to, int times){
        for(int i=0;i<times;i++){
            stacks[to].push(stacks[from].pop());
        }
    }

    private static void initStacks(){
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
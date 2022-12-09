package day06;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args){
        try(Scanner s = new Scanner(new FileInputStream("src/day06/input.txt"))){
            if(!s.hasNextLine())
                return;
            String content = s.nextLine();
            for(int i=4;i<content.length();i++){
                Set<Character> messageTest = content.substring(i-4,i).chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                if(messageTest.size()==4) {
                    System.out.println("found first message start @ position "+i);
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
package day06;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String[] args){
        try(Scanner s = new Scanner(new FileInputStream("src/day06/input.txt"))){
            if(!s.hasNextLine())
                return;
            String content = s.nextLine();
            for(int i=14;i<content.length();i++){
                    Set<Character> messageTest = content.substring(i-14,i).chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                    if(messageTest.size()==14) {
                        System.out.println("found first message start @ position "+(i+1));
                        break;
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
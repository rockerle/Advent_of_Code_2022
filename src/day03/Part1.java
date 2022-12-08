package day03;

import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Part1 {
    private static final String prios = ".abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args){
        try(Scanner s = new Scanner(new FileInputStream("src/day03/input.txt"))){
            AtomicInteger linePrio = new AtomicInteger(0);
            while(s.hasNextLine()){
                String line = s.nextLine();
                Set<Character> first = new LinkedHashSet<>(line.substring(0,line.length()/2).chars().mapToObj(e->(char)e).collect(Collectors.toSet()));
                Set<Character> second = new LinkedHashSet<>(line.substring(line.length()/2).chars().mapToObj(e->(char)e).collect(Collectors.toSet()));
                first.retainAll(second);
                first.forEach(c->linePrio.addAndGet(prios.indexOf(c)));
            }
            System.out.println("sum of prios is: "+linePrio);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
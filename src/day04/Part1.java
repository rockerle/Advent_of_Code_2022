package day04;

import day04.util.Range;

import java.io.FileInputStream;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args){
        int counter = 0;
        try(Scanner s = new Scanner(new FileInputStream("src/day04/input.txt"))){
            while(s.hasNextLine()){
                String[] line = s.nextLine().split(",");
                if(new Range(line[0]).isContainedIn(new Range(line[1])) || new Range(line[1]).isContainedIn(new Range(line[0]))){
                    System.out.println(line[0]+" is encapsulated by "+line[1]);
                    counter++;
                } else {
                    System.out.println(line[0]+" is not encapsulate by "+line[1]);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter + " section pairs are fully contained");
    }
}
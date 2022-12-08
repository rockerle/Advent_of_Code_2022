package day04;

import day04.util.Range;

import java.io.FileInputStream;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args){
        int counter = 0;
        try(Scanner s = new Scanner(new FileInputStream("src/day04/input.txt"))){
            while(s.hasNextLine()) {
                String[] line = s.nextLine().split(",");
                if (new Range(line[0]).overlap(new Range(line[1])))
                    counter++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("counted "+counter+" pairs of ranges that overlap");
    }
}
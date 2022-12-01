package day01;

import java.io.FileInputStream;
import java.util.*;

public class Day01 {
    private static HashMap<Integer, Integer> calorieMap = new HashMap<>();

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("src/day01/list.txt");
             Scanner s = new Scanner(in)) {
            int elveCounter = 1;
            int currentCalorieCount = 0;
            int top3CalorieCount = 0;

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.isBlank()) {
                    calorieMap.put(elveCounter, currentCalorieCount);
                    elveCounter++;
                    currentCalorieCount = 0;
                } else {
                    currentCalorieCount += Integer.parseInt(line);
                }
            }
            for(int i=1;i<4;i++){
                int topElve = (Collections.max(calorieMap.entrySet(), Map.Entry.comparingByValue()).getKey());
                System.out.println(i+": Elve nr."+topElve+" with "+calorieMap.get(topElve)+" calories");
                top3CalorieCount += calorieMap.get(topElve);
                calorieMap.remove(topElve);
            }
            System.out.println("sum of top 3 calories: "+top3CalorieCount);
        } catch (Exception e) {
            System.out.println("Something went wrong :(");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
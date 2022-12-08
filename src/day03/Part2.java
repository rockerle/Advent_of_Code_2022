package day03;

import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Part2 {
    private static final String prios = ".abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args){
        try(Scanner s= new Scanner(new FileInputStream("src/day03/input.txt"))){
            AtomicInteger prio = new AtomicInteger(0);
            while(s.hasNextLine()){
                Set<Character> lineOne = s.nextLine().chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                Set<Character> lineTwo = s.nextLine().chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                Set<Character> lineThree = s.nextLine().chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                getIntersections(List.of(lineOne,lineTwo,lineThree)).forEach(c->prio.addAndGet(prios.indexOf(c)));
            }
            System.out.println("sum of priorities: "+prio);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static Set<Character> getIntersections(List<Set<Character>> sets){
        Collection<Character>  first;
        if(sets==null || sets.size()==0 || (first = sets.get(0))==null)
            return Collections.emptySet();
        Set<Character> intersection = new HashSet<>(first);
        for(Collection c:sets){
            if(c==null)
                return Collections.emptySet();
            intersection.retainAll(c);
        }
        return intersection;
    }
}
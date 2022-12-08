package day04.util;

public class Range {
    int lowerBound;
    int upperBound;

    public Range(String s){
        try{
            String[] bounds = s.split("-");
            this.lowerBound = Integer.parseInt(bounds[0]);
            this.upperBound = Integer.parseInt(bounds[1]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean isContainedIn(Range otherRange){
        return (otherRange.lowerBound<=this.lowerBound && otherRange.upperBound>=this.upperBound);
    }

    public boolean overlap(Range otherRange){
        return Math.max(this.lowerBound, otherRange.lowerBound) <= Math.min(this.upperBound,otherRange.upperBound);
    }
}
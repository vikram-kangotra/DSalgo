import java.util.Arrays;
import java.util.Comparator;

public class Problems4 {
    
    /*
     * Merge Overlapping Intervals
     * Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.
     * Let the intervals be represented as pairs of integers for simplicity.
     * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     */

    class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public void mergeOverlappingIntervals(Interval[] arr){
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[index].end >= arr[i].start){
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }else{
                index++;
                arr[index] = arr[i];
            }
        }
        for(int i = 0; i <= index; i++){
            System.out.print("[" + arr[i].start + ", " + arr[i].end + "] ");
        }
    }

    public static void main(String[] args) {
        Problems4 p = new Problems4();
        Interval[] arr = {p.new Interval(2, 7), p.new Interval(3, 15), p.new Interval(18, 30), p.new Interval(2, 7)};
        p.mergeOverlappingIntervals(arr);
    }
}

import java.util.Arrays;

public class Problems5 {
    
    /*
     * Maximum guests in a party
     * Given arrival and departure times of all guests in a party, find the maximum number of guests at any time
     * The time intervals are given in the form of two arrays arr[] and dep[] of size n where arr[i] = arrival time of ith guest and dep[i] = departure time of ith guest
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     
     */

    public int maxGuests(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1;
        int j = 0;
        int max = 1;
        int count = 1;
        while(i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Problems5 p = new Problems5();
        int[] arr = {900, 600, 700};
        int[] dep = {1000, 800, 730};
        System.out.println(p.maxGuests(arr, dep));
    }
}

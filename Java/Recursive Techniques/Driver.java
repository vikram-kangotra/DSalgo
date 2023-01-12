import java.util.List;
import java.util.ArrayList;
public class Driver {
    public static void main(String[] args){
        Recursion r = new Recursion();
        System.out.println(r.josephus_problem2(5, 3));
        System.out.println(r.getSumOfDigits(256));
        r.allPalPartitions("nitin");
        List<Integer> list = new ArrayList<>();
        r.printSubsequences(0,list,new int[]{1,2,3});
        r.printSubsequencesWhoseSumEqualsK(0,list,0,4,new int[]{1,2,3});
        System.out.println("**" + r.countSubsequencesWhoseSumEqualsk(0, 0, 4, new int[]{1,3,2,2}));
        r.generateSubsets("abcd", 0, "");
        System.out.println(r.permute2(new int[]{1,2,3}));
    }
}
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class QueueProblems {
    // Reverse a queue
    public void reverseQueue(Queue<Integer> queue){
        if(queue.isEmpty()){
            return;
        }
        int data = queue.poll();
        reverseQueue(queue);
        queue.add(data);
    }

    // Check if a queue is a palindrome
    public boolean isPalindrome(Queue<Integer> queue){
        if(queue.isEmpty()){
            return true;
        }
        int data = queue.poll();
        boolean isPalindrome = isPalindrome(queue);
        queue.add(data);
        if(isPalindrome && data == queue.peek()){
            queue.poll();
            return true;
        }
        return false;
    }

    // Given a number n, print first n numbers (in increasing order) such that all these numbers have digits in set {5, 6}
    public ArrayList<Integer> printNumbers(int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(5);
        queue.add(6);
        while(n > 0){
            int data = queue.poll();
            result.add(data);
            queue.add(data * 10 + 5);
            queue.add(data * 10 + 6);
            n--;
        }
        return result;
    }

}

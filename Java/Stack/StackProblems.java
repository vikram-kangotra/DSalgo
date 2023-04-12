
import java.util.*;
public class StackProblems {
    
    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Stock Span Problem
    public int[] stockSpan(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

    // Previous Greater Element
    public int[] previousGreaterElement(int[] arr) {
        int[] pge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        pge[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return pge;
    }

    // Next Greater Element
    public int[] nextGreaterElement(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        nge[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return nge;
    }

    // Previous Smaller Element (Store index of element)
    public int[] previousSmallerElement(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        pse[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek(); // Store index of element
            }
            stack.push(i);
        }
        return pse;
    }

    // Next Smaller Element
    public int[] nextSmallerElement(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        nse[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = arr.length;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }

    // Maximum Area Histogram
    /*
     * Overall Algorithm in brief:
     * 1. Initialize : res = 
     * 2. Find previous smaller element for each element in array
     * 3. Find next smaller element for each element in array
     * 4. Do the following for every element in array considering it as the smallest element in the histogram
     *      curr = arr[i]
     *      curr +=(i - pse[i] - 1) * arr[i]
     *      curr += (nse[i] - i - 1) * arr[i]
     *      res = max(res, curr)
     * return res
     */
     
    public int maxAreaHistogram(int[] arr) {
        int[] pse = previousSmallerElement(arr);
        int[] nse = nextSmallerElement(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            curr += (i - pse[i] - 1) * arr[i];
            curr += (nse[i] - i - 1) * arr[i];
            res = Math.max(res, curr);
        }
        return res;
    }

    // Largest Rectangle with all 1's
    
    public int largestRectangleWithAll1s(int[][] arr) {
        int res = maxAreaHistogram(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            res = Math.max(res, maxAreaHistogram(arr[i]));
        }
        return res;
    }

    // Reverse individual words in a string

    public String reverseIndividualWords(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // Reverse a stack using recursion

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    public void insertAtBottom(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insertAtBottom(stack, temp);
        stack.push(val);
    }

    // Delete middle element of a stack
    public void deleteMiddleElement(Stack<Integer> stack, int size) {
        if (stack.isEmpty()) {
            return;
        }
        int mid = (size / 2) + 1;
        deleteMiddleElementUtil(stack, mid);
    }

    public void deleteMiddleElementUtil(Stack<Integer> stack, int mid) {
        if (mid == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElementUtil(stack, mid - 1);
        stack.push(temp);
    }

    // Sort a stack using recursion

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, temp);
    }

    public void insertInSortedOrder(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() < temp) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insertInSortedOrder(stack, temp);
        stack.push(val);
    }

    public static void main(String[] args) {
        StackProblems sp = new StackProblems();
        
        System.out.println(sp.maxAreaHistogram(new int[]{6, 2, 5, 4, 1, 5, 6}));
    }
     
}

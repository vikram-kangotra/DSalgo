import java.util.ArrayList;

public class MyStack1<T> {
    private ArrayList<T> stack;

    public MyStack1() {
        stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
    MyStack1<String> stack = new MyStack1<>();

    // Pushing elements onto the stack
    stack.push("apple");
    stack.push("banana");
    stack.push("cherry");
    stack.push("date");

    // Printing the contents of the stack
    System.out.println("Stack contents:");
    stack.printStack();

    // Peeking at the top element
    System.out.println("Top element: " + stack.peek());

    // Popping elements off the stack
    System.out.println("Popping elements:");
    while (!stack.isEmpty()) {
        System.out.println(stack.pop());
    }

    // Trying to pop an element from an empty stack
    System.out.println("Trying to pop an element:");
    try {
        stack.pop();
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
}

}

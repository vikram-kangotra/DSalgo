public class MyStack2<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack2() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T element = top.data;
        top = top.next;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        MyStack2<String> stack = new MyStack2<>();
    
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

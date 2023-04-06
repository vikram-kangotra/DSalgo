import java.util.NoSuchElementException;
public class CircularSinglyLinkedList<T> {
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        addFirst(data);
        tail = tail.next;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T removedData;
        if (size == 1) {
            removedData = tail.data;
            tail = null;
        } else {
            removedData = tail.next.data;
            tail.next = tail.next.next;
        }
        size--;
        return removedData;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<T> currentNode = tail.next;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
    
        // Adding elements to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
    
        // Printing the list
        System.out.print("Initial List: ");
        list.printList();
    
        // Removing elements from the list
        list.removeFirst();
    
        // Printing the list again
        System.out.print("List after removing first element: ");
        list.printList();
    
        // Adding elements to the list again
        list.addFirst(5);
        list.addLast(6);
    
        // Printing the list one more time
        System.out.print("List after adding elements: ");
        list.printList();
    }
    
}


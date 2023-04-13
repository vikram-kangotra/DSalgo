// Linked list implementation of a queue
public class Queue2<T> {
    
    private class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    public Queue2(){
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public T getFront(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    public T getRear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return rear.data;
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<T>(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        Node<T> temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    public static void main(String[] args) {
        Queue2<Integer> queue = new Queue2<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        System.out.println(queue.peek());
    }
}

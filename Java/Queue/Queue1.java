// Circular array based implementation of Queue

public class Queue1{
    private int capacity;
    private int front;
    private int size;
    private int[] queue;

    public Queue1(int capacity){
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        this.queue = new int[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int getFront(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int getRear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[(front + size - 1) % capacity];
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        queue[(front + size) % capacity] = data;
        size++;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        front = (front + 1) % capacity;
        size--;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for(int i = 0; i < size; i++){
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(6);
        queue.printQueue();
        System.out.println("Front: " + queue.getFront());
        System.out.println("Rear: " + queue.getRear());
        System.out.println("Size: " + queue.getSize());
    }
}
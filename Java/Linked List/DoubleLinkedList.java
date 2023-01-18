public class DoubleLinkedList {

    Node head = null;
   public void push(int data){
       Node newNode= new Node(data);
       if(head==null){
           head=newNode;
       }
       else {
           Node temp = head;
           newNode.prev = null;
           newNode.next = temp;
           temp.prev = newNode;
           head = newNode;
       }
   }
   public void printList(Node head){
       if(head==null) System.out.println("List is empty");
       else{
           Node temp = head;
           Node memp = null;
           System.out.println("Traversal in forward direction:");
           while(temp!=null){
               System.out.println(temp.data +" ");
               memp=temp;
               temp= temp.next;
           }
           System.out.println();
           System.out.println("Traversal in reverse direction");
           while(memp!=null){
               System.out.println(memp.data +" ");
               memp= memp.prev;
           }
       }
   }
       public void printInReverseDir(Node head){
       if(head==null) return;
         printInReverseDir(head.next);
           System.out.println(head.data +" ");
       }
       public void insertAfter(Node prev_node, int data){
         Node newNode= new Node(data);
         newNode.next=prev_node.next;
         newNode.prev=prev_node;
         prev_node.next=newNode;
         if(newNode.next!=null){
             newNode.next.prev=newNode;
         }
       }
       public void insertbefore(Node next_node, int data){
       if(next_node==null) System.out.println("The given next node cannot be null!");
         Node naya = new Node(data);
         naya.prev=next_node.prev;
         next_node.prev=naya;
         naya.next=next_node;
         if(naya.prev!=null)
             naya.prev.next=naya;
         else head=naya;
       }
       void append(int data){
       Node naya = new Node(data);
       Node last = head;
       naya.next=null;
       if(head==null){
           naya.prev=null;
           head=naya;
           return;

       }
           while (last.next!=null)  last=last.next;
           last.next=naya;
           naya.prev=last;
       }
       void deleteNode(Node del){
       if(head==null || del== null) return;
       if(head==del) head=del.next;
       if(del.next!=null) del.next.prev=del.prev;
       if(del.prev!=null) del.prev.next=del.next;
       return;
       }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.push(25);
        list.push(50);
        list.push(75);
        list.printList(list.head);
        list.printInReverseDir(list.head);
        list.printList(list.head);
    }

    class Node {
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data= data;
        next=null;
        prev=null;
    }
}
}

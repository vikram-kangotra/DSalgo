public  class Linked_LIst {
    Node head;
    public  void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next=head;
        head= new_node;
    }

    public void InsertAfter(Node prev_node, int data){
        Node new_node = new Node(data);
        if(prev_node==null){
           new_node=head;
        }
        new_node.next=prev_node.next;
        prev_node.next=new_node;
    }
    public void append(int new_data){
        Node new_node = new Node(new_data);
        if(head==null) {
            head=new_node;
        }
        Node n= head;
        while(n.next!=null){
            n=n.next;
        }
            n.next=new_node;
     }
    public void printList(){
        Node n = head;
        while (n!=null){
            System.out.println(n.data +" ");
            n=n.next;
        }
    }
    public void deleteNode(int key){
        Node temp =head; Node prev=null;
        if (temp==null){
            return;
        }
        if(temp!=null && temp.data==key){
             head=temp.next;
        }

        while(temp!=null && temp.data!=key){
            prev= temp;
            temp=temp.next;
        }
          prev.next= temp.next;
    }
    public void deleteNodeAtPosition(int position){
            if(head==null){
                return;
            }
            Node temp= head;
            if(position == 0){
                head=temp.next;
                return;
            }
            for(int i=0;temp!=null && i<position-1;i++){
                temp = temp.next;
            }
            if(temp==null || temp.next==null){
                return;
            }
            Node next = temp.next.next;
            temp.next=next;
    }
      public void deleteLinkedList(){
        head=null;
      }
      public int length(){
        Node temp=head;
        int count=0;
        while(temp!=null){
        temp=temp.next;
        count++;
        }
        return count;
      }
      public boolean searchIteratively(Node head, int x){
        Node current = head;
        while(current!=null){
            if(current.data==x){
                return true;
            }
            current=current.next;
        }
        return false;
      }
      public boolean searchRecursively(Node head, int x){
        if(head==null){
            return false;
        }
        if(head.data==x){
            return true;
        }
        return searchRecursively(head.next,x);
      }
      public void printNthFromLast(int n){
        int len=0;
        Node temp=head;
         while(temp!=null){
             temp=temp.next;
                     len++;
         }
         if(len<n) return;
         temp= head;
         for(int i=1;i<len-n+1;i++){
             temp=temp.next;
         }
          System.out.println(temp.data);
      }
         public void printNthFromLastRecursively(Node head, int n){
           if(head==null){
               return;
           }
           if(n==0){
               System.out.println(head.data);
           } else {
               printNthFromLastRecursively(head.next, n - 1);
           }
         }
         public void printMiddle(){
        Node slow_ptr=head;
        Node fast_ptr=head;
        while(fast_ptr!=null && fast_ptr.next!=null){
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;
        }
             System.out.println("The middle element is"+ slow_ptr.data);
         }

         public void deleteDuplicate(){
        Node curr = head;
        while(curr!=null){
            Node temp= curr;
            while(temp!=null && temp.data==curr.data){
                temp=temp.next;
            }
            curr.next=temp;
            curr=curr.next;
        }
         }
         
         static void removeDuplicate2(node head)
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();
 
        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null) {
            int curval = current.val;
 
            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }
    
    public Node deleteAllOccurrancesOfDuplicates(Node head) {
    Node t = new Node(0);
    t.next = head;
     Node p = t;
    while(p.next!=null&&p.next.next!=null){
        if(p.next.val == p.next.next.val){
            int dup = p.next.val;
            while(p.next!=null&&p.next.val==dup){
                p.next = p.next.next;
            }
        }else{
            p=p.next;
        }
 
    }
 
    return t.next;
}
    
    

         

    public static void main(String[] args) {
        Linked_LIst list = new Linked_LIst();
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.printList();
//        list.InsertAfter(list.head.next.next,10);
//        list.printList();
//        list.append(20);
//        list.printList();
//        list.deleteNode(5);
//        list.printList();
//        System.out.println(list.length());
//        System.out.println(list.searchRecursively(list.head,5));
//        System.out.println();
//        System.out.println();
         list.printNthFromLastRecursively(list.head,3);
    }


}


class Node {
    int data;
    Node next;
    Node(int data){
        this.data= data;
        next=null;
    }
}

import java.util.HashSet;
public class LinkedList1 {
    Node head;
    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean searchRecursively(Node head, int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        return searchRecursively(head.next, key);
    }

    public Node reverseLinkedList(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next; 
        }
        node = prev;
        return node;
    }

    public Node reverseLinkedlistRecur(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node rest = reverseLinkedlistRecur(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    public int getMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int countFrequency(Node head, int search_for){
        if(head == null){
            return 0;
        }
        if(head.data == search_for){
            return 1 + countFrequency(head.next, search_for);
        }
        else{
            return countFrequency(head.next, search_for);
        }
    }

    //Detect loop in linked list using floyd's cycle finding algorithm
    /*
     * Floyd’s Cycle-Finding Algorithm:
     * This is the fastest method and has been described below:
     * Traverse linked list using two pointers.
     * Move one pointer(slow_p) by one and another pointer(fast_p) by two.
     * If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
     */
    
    public boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // Find length of loop/cycle in linked list
    public int countNodesinLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return countNodes(slow);
            }
        }
        return 0;
    }

    private int countNodes(Node n){
        int res = 1;
        Node temp = n;
        while(temp.next != n){
            res++;
            temp = temp.next;
        }
        return res;
    }

    // Remove duplicates from sorted linked list
    public Node removeDuplicatesFromSortedList(Node head){
        Node current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return head;
    }

    // Remove duplicates from unsorted linked list
    public Node removeDuplicatesFromUnsortedList(Node head){
        Node current = head;
        Node prev = null;
        HashSet<Integer> hs = new HashSet<>();
        while(current != null){
            int curval = current.data;
            if(hs.contains(curval)){
                prev.next = current.next;
            }
            else{
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public Node intersectionOfTwoSortedLinkedList(Node head1, Node head2){
        Node intersecHead = null;
        Node intersecTail = null;

        while(head1 != null && head2 != null){
            if(head1.data == head2.data){
                if(intersecHead == null){
                    intersecHead = new Node(head1.data);
                    intersecTail = intersecHead;
                }
                else{
                    intersecTail.next = new Node(head1.data);
                    intersecTail = intersecTail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.data < head2.data){
                head1 = head1.next;
            }
            else{
                head2 = head2.next;
            }
        }
        return intersecHead;
    }

    public Node intersectionOfTwoUnsortedLinkedList(Node head1, Node head2){
        Node intersecHead = null;
        Node intersecTail = null;
        HashSet<Integer> hs = new HashSet<>();
        while(head1 != null){
            hs.add(head1.data);
            head1 = head1.next;
        }
        while(head2 != null){
            if(hs.contains(head2.data)){
                if(intersecHead == null){
                    intersecHead = new Node(head2.data);
                    intersecTail = intersecHead;
                }
                else{
                    intersecTail.next = new Node(head2.data);
                    intersecTail = intersecTail.next;
                }
            }
            head2 = head2.next;
        }
        return intersecHead;
    }

    public Node unionOfTwoSortedLinkedList(Node head1, Node head2){
        Node unionHead = null;
        Node unionTail = null;

        while(head1 != null && head2 != null){
            if(head1.data == head2.data){
                if(unionHead == null){
                    unionHead = new Node(head1.data);
                    unionTail = unionHead;
                }
                else{
                    unionTail.next = new Node(head1.data);
                    unionTail = unionTail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.data < head2.data){
                if(unionHead == null){
                    unionHead = new Node(head1.data);
                    unionTail = unionHead;
                }
                else{
                    unionTail.next = new Node(head1.data);
                    unionTail = unionTail.next;
                }
                head1 = head1.next;
            }
            else{
                if(unionHead == null){
                    unionHead = new Node(head2.data);
                    unionTail = unionHead;
                }
                else{
                    unionTail.next = new Node(head2.data);
                    unionTail = unionTail.next;
                }
                head2 = head2.next;
            }
        }
        while(head1 != null){
            if(unionHead == null){
                unionHead = new Node(head1.data);
                unionTail = unionHead;
            }
            else{
                unionTail.next = new Node(head1.data);
                unionTail = unionTail.next;
            }
            head1 = head1.next;
        }
        while(head2 != null){
            if(unionHead == null){
                unionHead = new Node(head2.data);
                unionTail = unionHead;
            }
            else{
                unionTail.next = new Node(head2.data);
                unionTail = unionTail.next;
            }
            head2 = head2.next;
        }
        return unionHead;
    }

    public Node unionOfTwoUnsortedLinkedList(Node head1, Node head2){
        Node unionHead = null;
        Node unionTail = null;
        HashSet<Integer> hs = new HashSet<>();
        while(head1 != null){
            hs.add(head1.data);
            head1 = head1.next;
        }
        while(head2 != null){
            hs.add(head2.data);
            head2 = head2.next;
        }
        for(int i : hs){
            if(unionHead == null){
                unionHead = new Node(i);
                unionTail = unionHead;
            }
            else{
                unionTail.next = new Node(i);
                unionTail = unionTail.next;
            }
        }
        return unionHead;
    }

    // Rotate linked list by k nodes

    public Node rotateLinkedList(Node head, int k){
        Node current = head;
        int count = 1;
        while(count < k && current != null){
            current = current.next;
            count++;
        }
        if(current == null){
            return head;
        }
        Node kthNode = current;
        while(current.next != null){
            current = current.next;
        }
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }

    // Write a function to get the intersection point of two Linked Lists.

    /*
     * There are two singly linked lists in a system. By some programming error, the end node of one of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a program to get the point where two linked lists merge. 
     */

    // By using the difference of length of two linked lists
    /*
     * 1. Calculate the lengths of both the linked lists.
     * 2. Calculate the difference in lengths of both the linked lists.
     * 3. Move the pointer of the longer linked list by the difference in lengths.
     * 4. Now move both the pointers of both the linked lists until they point to the same node.
     * 5. Return the node.
     */
    public Node getIntersectionNode1(Node headA, Node headB) {
        int lenA = 0;
        int lenB = 0;
        Node currentA = headA;
        Node currentB = headB;
        while(currentA != null){
            lenA++;
            currentA = currentA.next;
        }
        while(currentB != null){
            lenB++;
            currentB = currentB.next;
        }
        currentA = headA;
        currentB = headB;
        if(lenA > lenB){
            int diff = lenA - lenB;
            while(diff > 0){
                currentA = currentA.next;
                diff--;
            }
        }
        else{
            int diff = lenB - lenA;
            while(diff > 0){
                currentB = currentB.next;
                diff--;
            }
        }
        while(currentA != null && currentB != null){
            if(currentA == currentB){
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

    // Using two pointers approach
    public Node getIntersectionNode2(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        while(currentA != currentB){
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }
}

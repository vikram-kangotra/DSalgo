#include <iostream>

template<class T>
class Node {
    public:
    T data; 
    Node* next;

    Node() : data(0), next(nullptr) {}
    Node(T val) : data(val), next(nullptr) {}
    Node(T val, Node* nxt) : data(val), next(nxt) {}
};

template<class T>
class Circular {
    Node<T>* head;

    public:
    int size() {
        int count = 0;
        Node<T>* tp = head;
        while(tp->next != head) {
            tp = tp->next;
            count++;
        }
        return count+1;
    }

    Circular() : head(nullptr) {}

    Circular(T data) {
        head = new Node<T>(data);
        head->next = head;
    }

    Circular(T data, Node<T>* next) {
        head = new Node<T>(data, next);
        head->next = head;
    }

    Node<T>* insertNode(T data, size_t index) {
        if(head == nullptr) {
            head = new Node<T>(data);
            head->next = head;
        }
        else if(index == 0) {
            Node<T>* newNode = new Node<T>(data, head);
            Node<T>* temp = head;
            while(temp->next != head) {
                temp = temp->next;
            }
            temp->next = newNode;
            head = newNode;
        }
        else {
            Node<T>* newNode = new Node<T>(data);
            Node<T>* temp = head;
            while(index > 1 && temp->next != head) {
                temp = temp->next;
                index--;
            }
            newNode->next = temp->next;
            temp->next = newNode;
        }
        return head;
    }

    Node<T>* deleteNode(size_t index) {
        if (head != nullptr && head->next != head) {
            if(index == 0) {
                Node<T>* temp = head;
                while(temp->next != head) {
                    temp = temp->next;
                }
                temp->next = head->next;
                delete(head);
                head = temp->next;
            } else {
                Node<T>* temp = head;
                while(temp->next->next != head && index > 1) {
                    temp = temp->next;
                    index--;
                }
                Node<T>* delNode = temp->next;
                temp->next = temp->next->next;
                delete(delNode);
                delNode = nullptr;
            }
        }
        else {
            delete(head);
            head = nullptr;
        }

        return head;
    }

    Node<T>* sort() {
        Node<T>* temp = head;
        while(temp->next != head) {
            Node<T>* temp2 = temp->next;
            while(temp2 != head) {
                if(temp->data > temp2->data) {
                    T t = temp->data;
                    temp->data = temp2->data;
                    temp2->data = t;
                }
                temp2 = temp2->next;
            }
            temp = temp->next;
        }
        return head;
    }

    Node<T>* reverseList() {
        if( head != nullptr && head->next != head) {
            Node<T>* prevNode = nullptr;
            Node<T>* currNode = head;
            Node<T>* nextNode;

            while(currNode->next != head) {
                nextNode = currNode->next;
                currNode->next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }
            currNode->next = prevNode;
            head = currNode;
        } 
        return head;
    }

    void printList() {
        Node<T>* temp = head;
        while(temp->next != head) {
            std::cout << temp->data << " ";
            temp = temp->next;
        }
        std::cout << temp->data << std::endl;
    }
};

int main() {
    
    Circular<int> list(1);

    list.insertNode(2, 0);
    list.insertNode(3, 0);
    list.insertNode(4, 0);
    list.insertNode(5, 0);
    list.printList();

    list.deleteNode(0);
    list.printList();

    std::cout<<(list.size());

    list.sort();
    std::cout<<std::endl;
    list.printList();

    list.insertNode(11, 0);
    list.insertNode(0, 0);
    list.printList();
    
    list.reverseList();
    
    list.printList();
    return 0;
}

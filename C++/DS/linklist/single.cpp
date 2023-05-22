/*
 * This program is implementation of generic link list with help of templates.
 *
 * */

#include <iostream>
using namespace std;

template<class T>
class Node {
    public:
        T data;
        Node* next;

        Node() : data(0), next(nullptr){}
        Node(T val) : data(val), next(nullptr) {}
        Node(T val, Node* nxt) : data(val), next(nxt) {}

};

template<class T>
class LinkList {
    Node<T>* head;

    public:
    int size() {
        int count = 0;
        Node<T>* tp = head;
        while(tp != nullptr) {
            tp = tp->next;
            count++;
        }
        return count;
    }

    LinkList() : head(nullptr) {}

    LinkList(T data) {
        head = new Node<T>(data);
    }

    LinkList(T data, Node<T>* next) {
        head = new Node<T>(data, next);
    }

    Node<T>* insertNode(T data, size_t index) {
        if(head == nullptr) {
            head = new Node<T>(data);
        } else if( index == 0) {
            Node<T>* newNode = new Node<T>(data, head);
            head = newNode;
        } else {
            Node<T>* newNode = new Node<T>(data);
            Node<T>* temp = head;
            while(index > 1 && temp->next != nullptr) {
                temp = temp->next;
                index--;
            }
            newNode->next = temp->next;
            temp->next = newNode;
        }
        return head;
    }

    Node<T>* deleteNode(size_t index) {
        Node<T>* delNode;
        if (head != nullptr && head->next != nullptr) {
            if(index == 0) {
                delNode = head;
                head = head->next;
                delete(delNode);
                delNode = nullptr;
            } else {
                Node<T>* temp = head;
                while(temp->next->next != nullptr && index > 1) {
                    temp = temp->next;
                    index--;
                }
                delNode = temp->next;
                temp->next = delNode->next;
                delete(delNode);
                delNode = nullptr;
            }
        } else {
            delete(head);
            head = nullptr;
        }

        return head;

    }

    Node<T>* reverseList() {
        if( head != nullptr && head->next != nullptr) {
            Node<T>* prevNode = nullptr;
            Node<T>* currNode = head;
            Node<T>* nextNode;

            while(currNode != nullptr) {
                nextNode = currNode->next;
                currNode->next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }
            head = prevNode;
        } 
        return head;
    }

    Node<T>*  sort() {
        if(head != nullptr && head->next != nullptr) {
            //using insertion  sort.
            Node<T>* insert_at = head;
            while(insert_at->next != nullptr) {
                Node<T>* ptr_curr_min = insert_at;
                Node<T>* temp = insert_at->next;
                while (temp != nullptr) {
                    if(ptr_curr_min->data > temp->data)
                        ptr_curr_min = temp;
                    temp = temp->next;
                }

                if(insert_at->data != ptr_curr_min->data) {
                    T tp = insert_at->data;
                    insert_at->data = ptr_curr_min->data;
                    ptr_curr_min->data = tp;
                }
                insert_at = insert_at->next;
            }
        }
        return head;
    }
        void displayList() {
            if( head != nullptr) {
                Node<T>* temp = head;
                while (temp != nullptr) {
                    cout<<temp->data<<" ";
                    temp = temp->next;
                }
                cout<<endl;
            } else {
                cout<<"List is empty!"<<endl;
            }
        }
    };

    int main() {

        LinkList<int> int_list;
        int_list.displayList();
        int_list.insertNode(3, 0);
        int_list.insertNode(2, 0);
        int_list.insertNode(1, 0);
        int_list.insertNode(4, 3);
        int_list.insertNode(3, 100);
        int_list.sort();
        int_list.displayList();

        cout<<"List Current Size = "<<int_list.size()<<endl;

        //reverseList
        int_list.reverseList();
        int_list.displayList();

        //delete fuction
        int_list.deleteNode(2);
        int_list.deleteNode(3);
        int_list.deleteNode(0);
        int_list.displayList();

        //float
        LinkList<float> float_list;
        float_list.insertNode(4.5,0);
        float_list.insertNode(5.5, 0);
        float_list.insertNode(2.5, 1);
        float_list.sort();
        float_list.reverseList();
        float_list.displayList();

        //char
        LinkList<char> char_list;
        char_list.insertNode('I', 0);
        char_list.insertNode('R', 0);
        char_list.insertNode('P', 100);
        char_list.reverseList();
        char_list.sort();
        char_list.displayList();

        return  0;
    }

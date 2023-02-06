#include <iostream>
using namespace std;
class Stack
{
    int size;
    int *arr;
    int topIndex;

public:
    Stack(int size)
    {
        this->size = size;
        arr = new int[size];
        topIndex = -1;
    }
    void push(int value)
    {
        if (topIndex == size - 1)
        {
            cout << "Stack is Overflow!";
            return;
        }
        arr[++topIndex] = value;
    }
    void pop()
    {
        if (topIndex == -1)
        {
            cout << "Stack is Underflow!";
            return;
        }
        topIndex--;
    }
    bool empty()
    {
        if (topIndex == -1)
            return true;
        else
            return false;
    }
    int top()
    {
        if (topIndex == -1)
        {
            cout << "stack is Empty!";
            return -1;
        }
        return arr[topIndex];
    }
};
int main()
{
    Stack s(4);
    s.push(1);
    cout << s.top() << " ";
    s.push(3);
    cout << s.top() << " ";
    s.push(5);
    cout << s.top() << " ";
    s.push(5);
    cout << s.top() << " ";
    s.pop();
    cout << s.top() << " ";

    cout << endl;
}
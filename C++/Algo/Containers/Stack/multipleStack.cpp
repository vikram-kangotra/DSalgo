#include <iostream>
using namespace std;
class Stack
{
    int n; // size of array
    int k; // number of stacks
    int *arr;
    int *next;     // next[] is for save the position of previous element in a stack.
    int *topIndex; // array which stores indices of top elements of corresponding stack.
    int freeSpot;  // wii give index of free Space in array
public:
    Stack(int n, int k)
    {
        this->n = n;
        this->k = k;
        arr = new int[n];
        // initialising next array
        next = new int[n];
        for (int i = 0; i < n; i++)
        {
            next[i] = i + 1;
        }
        // updating Last element of next array
        next[n - 1] = -1;

        // initialising array of top
        topIndex = new int[k];
        for (int i = 0; i < k; i++)
        {
            topIndex[i] = -1;
        }

        freeSpot = 0; // initialise freeSpot
    }
    void push(int data, int m)
    {
        if (freeSpot == -1)
        {
            cout << "Space is Not Available!";
        }
        int index = freeSpot;
        freeSpot = next[index];          // Update freeSpot
        arr[index] = data;                 // inserting Value
        next[index] = topIndex[m - 1];
        /
            topIndex[m - 1] = index;
    }
    void pop(int m)
    {
        if (topIndex[m - 1] == -1)
        {
            cout << "This Stack is Empty";
        }
        int index = topIndex[m - 1];
        topIndex[m - 1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;
    }
    int top(int m)
    {
        if (topIndex[m - 1] == -1)
        {
            cout << "This Stack is Empty";
        }
        int index = topIndex[m - 1];
        return arr[index];
    }
};
int main()
{
    Stack s(4, 3);
    s.push(1, 1);
    s.push(2, 1);
    s.push(3, 2);
    s.push(4, 2);
    cout << s.top(2) << " ";
    s.pop(2);
    cout << s.top(2);
}
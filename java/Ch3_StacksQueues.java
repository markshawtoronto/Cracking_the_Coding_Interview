package com.CrackingTheCodingInterview;
import java.util.*;

class Stack<Object>
{
    Node top;

    class Node
    {
        Object data;
        Node next = null;

        public Node(Object d)
        {
            data = d;
        }
    }

    Object pop()
    {
        if (top != null)
        {
            Object item = top.data;
            top = top.next;
            return item;
        }

        return null;
    }

    void push(Object item)
    {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    boolean isEmpty()
    {
        if (top == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    Object peek()
    {
        return top.data;
    }
}

class Queue<Object>
{
    Node first, last;

    class Node
    {
        Object data;
        Node next = null;

        public Node(Object d)
        {
            data = d;
        }
    }

    Object dequeue()
    {
        if (first != null)
        {
            Object item = first.data;
            first = first.next;
            if (first == null)
            {
                last = null; // Empty queue
            }

            return item;
        }
        return null;
    }

    Object peek()
    {
        if (first != null)
        {
            return first.data;
        }
        else
        {
            return null;
        }
    }

    boolean isEmpty()
    {
        if (first == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void enqueue(Object item)
    {
        if (first == null)
        {
            last = new Node(item);
            first = last;
        }
        else
        {
            last.next = new Node(item);
            last = last.next;
        }
    }
}

// 3.1 - Use a single array to implement three stacks
class Three_stack_array
{
    // Stack 1 will use [0, n/3]
    // Stack 2 will use [n/3, 2n/3]
    // Stack 3 will use [2n/3, n]

    int stackSize = 100;
    int[] stack = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1}; // pointers to track top elements

    void push(int StackNum, int value)
    {
        // Check if we have space

        stackPointer[StackNum]++;
        stack[absTopOfStack(StackNum)] = value;
    }

    int pop(int StackNum)
    {
        // Check if empty
        if (isEmpty(StackNum))
        {
            throw new EmptyStackException();
        }

        int index = absTopOfStack(StackNum);
        int value = stack[index]; // Get top value
        stack[index] = 0; // Clear index
        stackPointer[StackNum]--; // Decrement pointer

        return value;
    }

    int peek(int StackNum)
    {
        if (isEmpty(StackNum))
        {
            throw new EmptyStackException();
        }

        int index = absTopOfStack(StackNum);
        return stack[index];
    }

    boolean isEmpty(int StackNum)
    {
        return stackPointer[StackNum] == -1;
    }

    // returns index of the top of "stackNum" in absolute terms
    int absTopOfStack(int StackNum)
    {
        return StackNum * stackSize + stackPointer[StackNum];
    }
}

// 3.2 -- Design a stack which can easily access the minimum value in O(1) time
class Stack_with_min
{
    Node top;
    Node min_stack;

    class Node
    {
        int data;
        Node next = null;

        public Node(int d)
        {
            data = d;
        }
    }

    int pop()
    {
        if (top != null)
        {
            int item = top.data;
            if (item == min_stack.data)
            {
                min_stack = min_stack.next;
            }

            top = top.next;
            return item;
        }
        return -1;
    }

    void push(int item)
    {
        if (min_stack == null || item <= min_stack.data)
        {
            Node m = new Node(item);
            m.next = min_stack;
            min_stack = m;
        }
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    int min()
    {
        return min_stack.data;
    }

    Object peek()
    {
        return top.data;
    }
}

// 3.3 -- Imagine a stack of plates. Once the stack is too high, we start a new stack. Implement this via stacks.
class Set_of_stacks
{
    ArrayList<Stack> stacks = new ArrayList<Stack>();

    class Stack
    {
        Node top;
        int capacity;
        int size;

        class Node
        {
            Integer data;
            Node next = null;

            public Node(Integer d)
            {
                data = d;
            }
        }

        Integer pop()
        {
            if (top != null)
            {
                Integer item = top.data;
                top = top.next;
                return item;
            }

            size--;

            return null;
        }

        void push(Integer item)
        {
            Node t = new Node(item);
            t.next = top;
            top = t;
            size++;
        }

        Integer peek()
        {
            return top.data;
        }

        boolean isEmpty()
        {
            if (peek() == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        boolean isFull()
        {
            if (size == capacity)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public void push(Integer data)
    {
        Stack last = getLastStack();
        if (last != null && !last.isFull())
        {
            // Add to last stack
            last.push(data);
        }
        else
        {
            // Create new stack.
            Stack new_stack = new Stack();
            new_stack.push(data);
            stacks.add(new_stack);
        }
    }

    public Integer pop()
    {
        // Retrieve last stack
        Stack last = getLastStack();
        return last.pop();
    }

    Stack getLastStack()
    {
        return stacks.get(stacks.size() - 1);
    }
}

// 3.4 -- Towers of Hanoi
// You have 3 towers and N disks of different sizes. The starting position is ascending order on one tower (each disk sits on top of a larger one)
// Move the disks from the first tower to the last using stacks.
class towers_of_hanoi
{
    // Testing method
    public static void main(String[] args) {
        towers_of_hanoi t = new towers_of_hanoi(10);
        t.solve();
    }

    ArrayList<Stack> stacks = new ArrayList<Stack>();
    int n_disks;

    // Setup towers of Hanoi. The first tower should have N disks of different sizes in its stack.
    public towers_of_hanoi(int n_disks)
    {
        this.n_disks = n_disks;

        // Setup each stack
        for (int i = 0; i < 3; i++)
        {
            Stack tower = new Stack<Integer>();
            stacks.add(tower);
        }

        // Setup first stack with all the blocks of the towers of hanoi, in order
        Stack<Integer> first = stacks.get(0);
        for (int i = n_disks; i > 0; i--)
        {
            // Add n_disks to the first stack
            // int i = 1 is the lightest, followed by i = 2, i = 3, up to n.
            first.push(i);
        }
    }

    // Solve towers of Hanoi
    public void solve()
    {
        Stack<Integer> origin = stacks.get(0);
        Stack<Integer> buffer = stacks.get(1);
        Stack<Integer> destination = stacks.get(2);

        // Start calling recursive solution method
        move_disks(this.n_disks, origin, destination, buffer);
    }

    // Move disks
    public void move_disks(int n, Stack<Integer> origin, Stack<Integer> destination, Stack<Integer> buffer)
    {
        // Base case / complete
        if (n <= 0)
        {
            return;
        }

        // Move n - 1 disks from the origin to the buffer, with the destination as the buffer
        move_disks(n - 1, origin, buffer, destination);

        // Move top from origin to destination
        move_top(origin, destination);

        // Move top n - 1 disks from buffer to destination, using origin as a buffer
        move_disks(n - 1, buffer, destination, origin);
    }

    public void move_top(Stack<Integer> origin, Stack<Integer> destination)
    {
        Integer top_block = origin.pop();
        destination.push(top_block);
        System.out.println("Move disk "+top_block);
    }
}

// 3.5 - Implement a Queue using two Stacks
class MyQueue
{
    // Testing method.
    public static void main(String[] args)
    {
        MyQueue mq = new MyQueue();
        // Enqueue 0 to 9
        for (int i = 0; i < 10; i++)
        {
            mq.enqueue(i);
        }

        // Print the output of dequeue all.
        // Expect it to be 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i < 10; i++)
        {
            System.out.println(mq.dequeue());
        }
    }

    Stack<Integer> stackNewest, stackOldest;

    // Constructor
    public MyQueue()
    {
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public void enqueue(Integer value)
    {
        // Always push to stackNewest, which has the newest elements on top
        stackNewest.push(value);
    }

    public Integer dequeue()
    {
        // Always transfer all items from stackNewest to stackOldest, then pop the oldest item off stackOldest.
        this.shiftStacks();
        return stackOldest.pop();
    }

    public void shiftStacks()
    {
        if (stackOldest.isEmpty())
        {
            while(!stackNewest.isEmpty())
            {
                stackOldest.push(stackNewest.pop()); // Transfer phase.
            }
        }
    }
}

// 3.6 -- Sort a stack in ascending order. You may use one additional stack, but may not copy data to any other data structure.
class Sorted_stack
{
    // The limitation that we can only use two stacks total calls for a modified insertion sort (grab each element and insert it into its correct place in the new structure).
    // This is O(n^2) in time.
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> buffer = new Stack<Integer>();
        while (!s.isEmpty())
        {
            int temp = s.pop(); // Hold temporary integer until we find its home.
            while (!buffer.isEmpty() && buffer.peek() > temp)
            {
                s.push(buffer.pop()); // Transfer elements from buffer over to origin until temp has its correct home on the buffer stack.
            }
            buffer.push(temp);
        }

        return buffer; // Buffer is now a completely ordered stack, return it and we're done.
    }
}

// 3.7 -- An animal shelter holds dogs and cats, and operates like a queue.
// People visiting the shelter can either request the oldest of either animal, or prefer a dog or cat.
class animal_shelter
{
    Queue<Date> dogs = new Queue<Date>();
    Queue<Date> cats = new Queue<Date>();

    public void enqueue(String animal_type)
    {
        Date current_time = new Date();
        if (animal_type.equals("dog"))
        {
            dogs.enqueue(current_time);
        }
        else if (animal_type.equals("cat"))
        {
            cats.enqueue(current_time);
        }
    }

    public Date dequeueAny()
    {
        // Retrieve both times for comparison
        if (dogs.peek() == null)
        {
            return cats.dequeue();
        }
        if (cats.peek() == null)
        {
            return dogs.dequeue();
        }
        Date most_recent_dog = dogs.peek();
        Date most_recent_cat = cats.peek();

        if (most_recent_dog.compareTo(most_recent_cat) == -1) // Next Dog has been waiting longer than next cat.
        {
            return dogs.dequeue();
        }
        else
        {
            return cats.dequeue();
        }
    }

    public Date dequeueDog()
    {
        return dogs.dequeue();
    }

    public Date dequeueCat()
    {
        return cats.dequeue();
    }
}
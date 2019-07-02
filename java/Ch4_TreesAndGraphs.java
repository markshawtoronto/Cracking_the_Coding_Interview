package com.CrackingTheCodingInterview;
import java.util.*;

// Basic tree structure, used for a binary search tree
class Tree<Object>
{
    Node top;
    Object target;

    class Node
    {
        Object data;
        boolean visited;
        boolean match;
        Node rightChild = null;
        Node leftChild = null;
        Node parent = null;

        public Node(Object d)
        {
            data = d;
            match = false;
            visited = false;
        }
    }

    void depth_first_search(Node root)
    {
        if (root == null) return;

        visit(root);
        root.visited = true;
        if (root.leftChild != null && !root.leftChild.visited)
        {
            depth_first_search(root.leftChild);
        }
        if (root.rightChild != null && !root.rightChild.visited)
        {
            depth_first_search(root.rightChild);
        }
    }

    void depth_first_search_2(Node root)
    {
        if (root == null) return;

        visit(root);
        root.visited = true;
        if (root.leftChild != null && !root.leftChild.visited)
        {
            depth_first_search_2(root.leftChild);
        }
        if (root.rightChild != null && !root.rightChild.visited)
        {
            depth_first_search_2(root.rightChild);
        }
    }

    void breadth_first_search_2(Node root)
    {
        Queue<Node> queue = new Queue<Node>();

        visit(root);
        root.visited = true;

        queue.enqueue(root);

        while (!queue.isEmpty())
        {
            Node r = queue.dequeue();

            if (r.leftChild != null && !r.leftChild.visited)
            {
                visit(r.leftChild);
                r.leftChild.visited = true;
                queue.enqueue(r.leftChild);
            }
            if (r.rightChild != null && !r.rightChild.visited)
            {
                visit(r.rightChild);
                r.rightChild.visited = true;
                queue.enqueue(r.rightChild);
            }
        }
    }

    void breadth_first_search(Node root)
    {
        Queue<Node> queue = new Queue<Node>();
        root.visited = true;
        visit(root);
        queue.enqueue(root); // Add to the end of queue

        while (!queue.isEmpty())
        {
            Node r = queue.dequeue(); // Remove from the front of the queue
            if (r.leftChild != null && !r.leftChild.visited)
            {
                visit(r.leftChild);
                r.leftChild.visited = true;
                queue.enqueue(r.leftChild);
            }
            if (r.rightChild != null && !r.rightChild.visited)
            {
                visit(r.rightChild);
                r.rightChild.visited = true;
                queue.enqueue(r.rightChild);
            }
        }
    }

    void visit(Node n)
    {
        if (n.data == target)
        {
            n.match = true;
        }
        else
        {
            n.match = false;
        }
    }

    // 4.1 -- Check if a binary tree is balanced.
    // For this question, balanced is defined as a tree such that the heights of the two subtrees never differ by more than one
    public int checkHeight(Node root)
    {
        if (root == null)
        {
            return 0; // Height of 0.
        }

        // Check left (recursively)
        int leftHeight = checkHeight(root.leftChild);
        if (leftHeight == -1)
        {
            return -1; // Not balanced
        }

        // Check right (recursively)
        int rightHeight = checkHeight(root.rightChild);
        if (rightHeight == -1)
        {
            return -1; // Not balanced
        }

        // Check if current node is balanced
        int heightDifference = rightHeight - leftHeight;

        if (Math.abs(heightDifference) > 1)
        {
            return -1; // Not balanced
        }
        else
        {
            return Math.max(leftHeight, rightHeight) + 1; // Return height
        }
    }

    public boolean isBalanced(Node root)
    {
        if (checkHeight(root) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}

// Integer tree is the same as above but demands Integer data.
class Integer_Tree extends Tree<Integer>
{
    // 4.3 -- Given a sorted array (increasing order) with unique integer elements, write an algorithm to create a binary search tree with minimal height
    public static void main(String[] args)
    {
        Integer[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Integer_Tree it = new Integer_Tree();
        Node output = it.createMinimalBST(input, 0, input.length - 1, null);

        it.breadth_first_search(output);
    }

    // 4.3 (cont) -- Insert a node into the BST.
    public Node createMinimalBST(Integer[] input, int start, int end, Node parent)
    {
        if (end < start)
        {
            return null; // We've finished with this section
        }

        int mid = (start + end) / 2; // int always rounds
        Node n = new Node(input[mid]);
        n.parent = parent;
        n.leftChild = createMinimalBST(input, start, mid - 1, n);
        n.rightChild = createMinimalBST(input, mid + 1, end, n);
        return n;
    }

    // 4.4 -- Given a binary tree, create a linked list of all the nodes at each depth
    // If you have a tree with depth D, you'll have D linked lists
    void linked_list_from_BST(Node input, Integer depth, ArrayList<LinkedList<Node>> lists)
    {
        // Use a modified version of depth first search.
        if (input == null) return;

        LinkedList<Node> list = null; // Initialize

        // Check if this list has been added for this depth yet.
        if (lists.size() <= depth) // Check if the ArrayList of linked lists contains has this depth started yet.
        {
            // Initialize this depth.
            list = new LinkedList<Node>();
            lists.add(list);
        }
        else
        {
            // Grab the existing list for this depth
            list = lists.get(depth);
        }

        list.add(input);
        linked_list_from_BST(input.leftChild, depth + 1, lists);
        linked_list_from_BST(input.rightChild, depth + 1, lists);
    }

    // 4.5 -- Check if a binary tree is a binary search tree
    boolean check_if_BST(Node input)
    {
        // Use a modified version of depth first search
        if (input == null)
        {
            return true;
        }

        // Perform check
        if ((input.leftChild != null && input.leftChild.data <= input.data) && (input.rightChild != null && input.rightChild.data > input.data))
        {
            boolean check_left = check_if_BST(input.leftChild);
            boolean check_right = check_if_BST(input.rightChild);

            if (!check_left || !check_right)
            {
                return false;
            }
        }
        else if ((input.leftChild != null && input.leftChild.data > input.data) || (input.rightChild != null && input.rightChild.data <= input.data))
        {
            return false;
        }
        else if (input.leftChild != null && input.leftChild.data <= input.data)
        {
            boolean check_left = check_if_BST(input.leftChild);
            if (!check_left)
            {
                return false;
            }
        }
        else if (input.rightChild != null && input.rightChild.data > input.data)
        {
            boolean check_right = check_if_BST(input.rightChild);
            if (!check_right)
            {
                return false;
            }
        }

        return true; // All good!
    }

    // 4.6 -- Find the 'next' node (in-order traversal) of a given node in a binary search tree. Each node has a link to its parent.
    Node find_next_node(Node input)
    {
        // The "next" node is the next element of an in-order traversal.
        // In order traversal goes leftChild, current, rightChild.
        if (input == null) return null;

        // If there are any righthand children, the 'next' node is the most left child on the right tree.
        if (input.rightChild != null)
        {
            return left_most_child(input.rightChild);
        }
        else // Otherwise it must be one of the parents.
        {
            Node parent = input.parent;
            Node current = input;

            // Go up the tree until we are in a position where the left child is our last stop.
            while (parent != null && parent.leftChild != input)
            {
                current = parent;
                parent = current.parent;
            }

            return parent;
        }
    }

    public Node left_most_child(Node input)
    {
        if (input == null) return null;

        while (input.leftChild != null)
        {
            input = input.leftChild;
        }

        return input;
    }

    // 4.7 -- Find the first common ancestor of two nodes in a binary tree.
    // Assume both do exist in the tree (solution 2)
    Node find_common_ancestor(Node current, Node input1, Node input2)
    {
        if (current == null) return null;

        // Check if they're identical.
        if (current == input1 && current == input2)
        {
            return current;
        }

        Node left_tree_result = find_common_ancestor(current.leftChild, input1, input2);
        if (left_tree_result != null && left_tree_result != input1 && left_tree_result != input2)
        {
            return left_tree_result;
        }

        Node right_tree_result = find_common_ancestor(current.rightChild, input1, input2);
        if (right_tree_result != null && right_tree_result != input1 && right_tree_result != input2)
        {
            return right_tree_result;
        }

        // input1 and input2 are found in different trees
        if (left_tree_result != null && right_tree_result != null)
        {
            return current; // If they're in different trees, this is the common ancestor
        }
        else if (current == input1 || current == input2)
        {
            return current;
        }
        else
        {
            // If either is non-null, return the non-null value
            if (left_tree_result != null)
            {
                return left_tree_result;
            }
            else if (right_tree_result != null)
            {
                return right_tree_result;
            }
            else
            {
                return null;
            }
        }
    }

    // 4.8 - Write an algorithm to determine if a binary tree is a subtree of another binary tree.
    // Take the situation where big_input is a binary search tree.
    boolean subtree_check(Node big_input, Node small_input)
    {
        // Find the point at which a Node in small_input == a Node in big_input
        // This is a search at a speed of log(n).

        if (big_input == null) return false;

        if (big_input.data.equals(small_input.data))
        {
            return subtree_check_equality(big_input, small_input);
        }
        else
        {
            if (big_input.data < small_input.data)
            {
                return subtree_check(big_input.rightChild, small_input);
            }
            else if (big_input.data > small_input.data)
            {
                return subtree_check(big_input.leftChild, small_input);
            }
        }

        // No matching small_input top data discovered.
        return false;
    }

    // If any nodes in big_input or small_input do not exactly equal each other, return false.
    boolean subtree_check_equality(Node big_input, Node small_input)
    {
        if (big_input == null) return true;
        if (small_input == null) return true;

        if (!big_input.data.equals(small_input.data)) // If the nodes do not equal, return false
        {
            return false;
        }
        else
        {
            boolean result_left = subtree_check_equality(big_input.leftChild, small_input.leftChild);
            boolean result_right = subtree_check_equality(big_input.rightChild, small_input.rightChild);

            if (!result_left || !result_right)
            {
                return false;
            }
        }

        return true;
    }

    // 4.9 -- You are given a binary tree in which each node contains an integer (positive or negative).
    // Print all paths which sum to a given value. Paths can start and end anywhere.

    void findSum(Node input, int sum, int[] path, int depth)
    {
        if (input == null) return;

        path[depth] = input.data;

        // Look for paths with a sum that ends on this node.
        int t = 0;
        for (int i = depth; i >= 0; i--)
        {
            t += path[i];
            if (t == sum)
            {
                print(path, i, depth);
            }
        }

        // Search nodes beneath this one
        findSum(input.leftChild, sum, path, depth+1);
        findSum(input.rightChild, sum, path, depth+1);
    }

    // Setup and run
    void findSum(Node input, int sum)
    {
        int depth = depth(input);
        int[] path = new int[depth];
        findSum(input, sum, path, 0);
    }

    void print(int[] path, int start, int end)
    {
        for (int i = start; i <= end; i++)
        {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    int depth(Node input)
    {
        if (input == null)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(depth(input.leftChild), depth(input.rightChild));
        }
    }
}
package com.CrackingTheCodingInterview;
import java.util.*;

// Singly linked list.
class Node
{
	// Testing method
	public static void main(String[] args) {

		Node n = new Node(3);
		n.next = new Node(2);
		n.next.next = new Node(1);

		Node n2 = new Node(3);
		n2.next = new Node(2);
		n2.next.next = new Node(1);

		Node formatted_list = sum_reversed_linked_lists(n, n2, 0);
	}

	Node next = null;
	int data;

	public Node(int d)
	{
		data = d;
	}

	void appendtoTail(int d)
	{
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
		{
			n = n.next;
		}
		n.next = end;
	}

	Node deleteNode(Node head, int d)
	{
		Node n = head;

		if (n.data == d) // Head of the linked list is the one we want.
		{
			return head.next; // Moved head. No need to change other nodes.
		}

		while (n.next != null)
		{
			if (n.next.data == d)
			{
				n.next = n.next.next;
				return head; // Head didn't change
			}
			n = n.next;
		}

		return head;
	}

	// 2.1 Remove duplicates from an unsorted linked list
	public static Node removeDuplicates(Node head)
	{
		// Try using a hashmap like in Ch1
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Iterate over linked list
		Node n = head;

		while (n.next != null)
		{
			if (map.containsKey(n.next.data))
			{
				// Delete the node.
				n.next = n.next.next;
			}
			else
			{
				// Add node to the hashmap
				map.put(n.data, 1);
			}
			n = n.next;
		}

		return head;
	}

	// 2.2 Find the kth last element of a singly linked list
	public static int find_kth_element(Node head, int k)
	{
		// Use recursion
		if (head == null)
		{
			return 0;
		}

		int i = find_kth_element(head.next, k) + 1;
		if (i == k)
		{
			System.out.println(head.data);
		}

		return i;
	}

	// 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
	public static boolean delete_kth_node(Node n)
	{
		if (n == null || n.next == null) // Not possible if it is the last node in the linked list
		{
			return false;
		}
		else
		{
			Node next = n.next;
			n.data = next.data;
			n.next = next.next;
			return true;
		}
	}

	// 2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
	// CORRECT
	public static Node partition_linked_list(Node n, int x)
	{
		// Possible strategy: create two new linked lists as we iterate through this one.
		Node lesser_list_start = null;
		Node greater_list_start = null;
		Node lesser_list_end = null;
		Node greater_list_end = null;

		while (n != null)
		{
			Node next = n.next;
			n.next = null;
			if (n.data < x)
			{
				if (lesser_list_start != null)
				{
					lesser_list_end.next = n;
					lesser_list_end = n;
				}
				else
				{
					lesser_list_start = new Node(n.data);
					lesser_list_end = lesser_list_start;
				}
			}
			else
			{
				if (greater_list_start != null)
				{
					greater_list_end.next = n;
					greater_list_end = n;
				}
				else
				{
					greater_list_start = n;
					greater_list_end = greater_list_start;
				}
			}
			n = next;
		}

		// Merge the two lists
		lesser_list_end.next = greater_list_start;

		return lesser_list_start;
	}

	// 2.5 - Add two numbers stored in reverse order in a linked list.
	public static Node sum_reversed_linked_lists(Node n1, Node n2, int carry)
	{
		// Since the numbers are stored in reverse order, we have access to the 1s column first.
		// Add the numbers together, then "carry" the extra digit to the next addition.
		if (n1 != null || n2 != null)
		{
			int value = n1.data + n2.data + carry;
			Node more = sum_reversed_linked_lists(n1 == null ? null : n1.next,
												  n2 == null ? null : n2.next,
												  value >= 10 ? 1 : 0);
			Node new_node = new Node(value % 10);
			new_node.next = more;

			return new_node;
		}

		return null;
	}

	// 2.6 - Check if a linked list is circular.
	public boolean detect_linked_list_circularity(Node head)
	{
		Node p = head;
		Node n = head;

		// Strategy - pass two iterators going at different speeds. If they intersect, it is circular.
		while (p != null && p.next != null)
		{
			Node next = n.next;
			Node fast_next = p.next.next;

			if (next == fast_next)
			{
				return true;
			}

			n = next;
			p = fast_next;
		}

		// End was reached with no recursion detected.
		return false;
	}

	// 2.7 - Detect a palindrome linked list
	public boolean detect_linked_list_palindrome(Node head)
	{
		// Use a stack.
		// The length of the linked list is unknown here, but we can determine it by using the two pointers method.
		// When the fast pointer reaches the end of the linked list, the slow pointer is at the mid-point.
		// Once the slow pointer is at the midpoint, stop adding to the stack, and start checking the remaining elements against the items removed from the stack one at a time.

		Stack<Integer> stack = new Stack<Integer>();
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null)
		{
			Node slow_next = slow.next;
			Node fast_next = fast.next.next;

			stack.push(slow.data);

			slow = slow_next;
			fast = fast_next;
		}

		// Has odd number of elements
		if (fast != null)
		{
			slow = slow.next; // Skip the middle element then
		}

		while (slow != null)
		{
			int top = stack.pop();

			if (top != slow.data)
			{
				return false;
			}

			slow = slow.next;
		}

		return true;
	}
}
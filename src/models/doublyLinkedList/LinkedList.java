/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Heap sort is good when memory is tight, and you are sorting many small items that come stored in an array
//Merge sort is good for data thats to big to have in memory at once,because its pattern of storage access is very regular;
//Its also uses even fewer comparisons than heap sort, and is especially suitted for data stored as linked lists;
//Quick sort also uses few comparisons( somewhat more than the other two).Like heap sort it can sort in place by moving data in an array;
package models.doublyLinkedList;

/**
 *
 * @author Ulan
 */
public class LinkedList {
	static Node head;

	static class Node {
		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			prev = next = null;
		}
	}

	void print(Node node) {
		Node last = node;
		System.out.println("Forward Traversal using next pointer");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println("\nBackward Traversal using prev pointer");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
		System.out.println();
	}

	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);
		node = mergeSort(node);
		second = mergeSort(second);

		return merge(node, second);
	}

	Node merge(Node first, Node second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}

		if (first.data <= second.data) {
			first.next = merge(first.next, second);
			first.next.prev = first;
			first.prev = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.prev = second;
			second.prev = null;
			return second;

		}
	}

	Node add(int data) {
		Node n_node = new Node(data);
		if (head == null) {
			head = n_node;
			return head;
		}
		head.prev = n_node;
		n_node.next = head;
		head = n_node;
		return head;
	}

	Node addAfter(int data, Node node) {
		Node n_node = new Node(data);
		if (node == null) {
			System.out.println("Given node cannot be empty");
			return node;
		}
		Node temp = head;
		while (temp.next != null && temp != node) {
			temp = temp.next;
		}
		n_node.next = temp.next;
		n_node.prev = temp;
		temp.next = n_node;
		if (n_node.next != null)
			n_node.next.prev = n_node;
		return head;
	}

	Node addAfter(int data, int k) {
		Node n_node = new Node(data);
		Node temp = head;
		while (temp.next != null && temp.data != k) {
			temp = temp.next;
		}

		n_node.next = temp.next;
		n_node.prev = temp;
		temp.next = n_node;
		if (n_node.next != null)
			n_node.next.prev = n_node;
		return head;
	}

	Node addBefore(int data, Node node) {
		Node n_node = new Node(data);
		if (node == null) {
			System.out.println("Given node cannot be empty");
			return node;
		}
		if (head == node) {
			n_node.next = head;
			head.prev = n_node;
			head = n_node;
			return head;
		}
		Node temp = head;
		while (temp.next != null && temp != node) {
			temp = temp.next;
		}
		n_node.prev = temp.prev;
		temp.prev = n_node;
		n_node.next = temp;
		n_node.prev.next = n_node;
		return head;
	}

	Node addBefore(int data, int k) {
		Node n_node = new Node(data);
		if (head.data == k) {
			n_node.next = head;
			head.prev = n_node;
			head = n_node;
			return head;
		}
		Node temp = head;
		while (temp.next != null && temp.data != k) {
			temp = temp.next;
		}
		n_node.prev = temp.prev;
		temp.prev = n_node;
		n_node.next = temp;
		n_node.prev.next = n_node;
		return head;
	}

	Node append(int data) {
		Node n_node = new Node(data);
		if (head == null) {
			head = n_node;
			return head;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = n_node;
		n_node.prev = last;
		return head;
	}

	Node delete(Node del) {
		if (head == null || del == null)
			return head;

		if (head == del) // Case 1 : Deleting the head node
			head = del.next;

		if (del.next != null) // If it's not the last element
			del.next.prev = del.prev;

		if (del.prev != null) // If it's not the first element
			del.prev.next = del.next;

		return head;
	}

	Node delete(int d) {
		/* base case */
		if (head == null) {
			return head;
		}

		/* If node to be deleted is head node */
		if (head.data == d) {
			if (head.next != null)
				head.next.prev = null;
			head = head.next;
			return head;
		}

		Node del = head;
		while (del != null && del.data != d) {
			del = del.next;
		}
		if (del.next == null) {
			del.prev.next = null;
			del.prev = null;
		}
		/* Change next only if node to be deleted is NOT the last node */
		if (del.next != null) {
			del.next.prev = del.prev;
		}

		/* Change prev only if node to be deleted is NOT the first node */
		if (del.prev != null) {
			del.prev.next = del.next;
		}

		/* Finally, free the memory occupied by del */
		return head;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.add(30);
		list.add(4);
		list.add(20);
		list.add(5);
		list.add(10);
		list.add(3);

		list.quickSort(head);
		System.out.println("Linked list after sorting :");
		list.print(head);
	}

	Node lastNode(Node node) {
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	Node partition(Node l, Node h) {
		int x = h.data; // sets pivot element as h element
		// similar to i = l -1 for array implementation
		Node i = l.prev;
		// Similar to "for(int j = 1; j <= h - 1; j++)"
		for (Node j = l; j != h; j = j.next) {
			if (j.data <= x) {
				// Similar to i++ for array
				i = (i == null) ? l : i.next;
				int temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
		}
		i = (i == null) ? l : i.next;// Similar to i++
		int temp = i.data;
		i.data = h.data;
		h.data = temp;
		return i;
	}

	void _quickSort(Node l, Node h) {
		if (h != null && l != h && l != h.next) {
			Node temp = partition(l, h);
			_quickSort(l, temp.prev);
			_quickSort(temp.next, h);
		}
	}

	public void quickSort(Node node) {
		Node head = lastNode(node);
		_quickSort(node, head);
	}

}

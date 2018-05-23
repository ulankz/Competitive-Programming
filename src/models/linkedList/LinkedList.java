/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.linkedList;

/**
 *
 * @author Ulan
 */
public class LinkedList {
	Node head;

	class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node n_node = new Node(data);
		n_node.next = head;
		head = n_node;
	}

	public void insertAfter(Node prev, int data) {
		if (prev == null) {
			System.out.println("Given prev node cannot be null");
			return;
		}
		Node n_node = new Node(data);
		n_node.next = prev.next;
		prev.next = n_node;
	}

	public void append(int data) {
		Node n_node = new Node(data);
		if (head == null) {
			head = n_node;
			head.next = null;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = n_node;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public int getLength() {
		return getLengthRecursive(head);
	}

	private int getLengthRecursive(Node head) {
		if (head == null) {
			return 0;
		}
		return 1 + getLengthRecursive(head.next);
	}

	public int getLengthIterative() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public int getLengthIterative(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public boolean isPalindrome(Node head) {
		Node p = head;
		Node q = head;
		Node start_second = null;
		if (p.next == null) // if there is only one character in the string
		{
			return true;
		}
		while (true) {
			p = p.next.next;
			if (p == null) {// If even
				start_second = q.next;
				break;
			}
			if (p.next == null) { // If odd, then ignore the middle node
				start_second = q.next.next;
				break;
			}
			q = q.next;
		}
		q.next = null;// split into two linkedLists
		return CompareListsRecursive(p, reverseList(q));
	}

	public Node reverseList(Node head) {
		Node next = null, prev = null, curr = head;
		while (curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	public Node reverseRecursive(Node head) {
		Node p = null, q = null;
		if (head == null)
			return head;
		p = head;
		q = p.next;
		if (q == null)
			return p;
		q = reverseRecursive(q);
		p.next.next = p;
		p.next = null;
		return q;
	}

	public boolean compareLists(Node a, Node b) {
		Node temp1 = a;
		Node temp2 = b;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else
				return false;
		}

		/* Both are empty return 1 */
		if (temp1 == null && temp2 == null)
			return true;

		/*
		 * Will reach here when one is NULL and other is not
		 */
		return false;
	}

	public boolean CompareListsRecursive(Node headA, Node headB) {
		if (headA == null && headB == null) {
			return true;
		}
		if (headA == null || headB == null)
			return false;
		if (headA.data != headB.data)
			return false;
		return CompareListsRecursive(headA.next, headB.next);
	}

	public Node removeDuplicatesSortedLists(Node head) {
		Node p = head;
		Node q = null;
		while (p != null && p.next != null) {
			if (p.data == p.next.data) {
				q = p.next.next;
				p.next = q;
			} else {
				p = p.next;
			}
		}
		return q;
	}

	public Node removeDuplicatesUnsortedLists(Node head) {
		int[] hash = new int[1000];
		for (int i = 0; i < hash.length; i++) {
			hash[i] = 0;
		}
		Node p = head;
		Node q = null;
		while (p != null && p.next != null) {
			if (hash[p.data] == 0) {
				hash[p.data] = 1;
				q = p;
			} else {
				q.next = p.next;
			}
			p = p.next;
		}
		return p;
	}

	public int IntersectionPointOfLinkedList(Node a, Node b) {
		int a_length = getLengthIterative(a);
		int b_length = getLengthIterative(b);
		Node pA = a, pB = b;
		int diff = Math.abs(a_length - b_length);
		if (a_length > b_length) {
			for (int i = 0; i < diff; i++) {
				pA = pA.next;
			}
		} else {
			for (int i = 0; i < diff; i++) {
				pB = pB.next;
			}
		}
		while (pA != null && pB != null) {
			if (pA.data == pB.data)
				return pA.data;
			pA = pA.next;
			pB = pB.next;
		}

		return -1;
	}

	public Node rotate(Node head, int r) {

		Node p = head, q = null, new_head = null;
		while (p != null) {
			if (r == p.data) {
				break;
			}
			p = p.next;
		}
		new_head = p.next;
		p.next = null;
		q = new_head;

		while (q.next != null) {
			q = q.next;
		}
		q.next = head;
		return new_head;
	}

	public Node swap_pairs(Node start) {
		Node p = start, new_start = p.next, q = null, temp = null;
		while (true) {
			q = p.next;
			temp = q.next;
			q.next = p;
			if (temp == null) {
				p.next = null;
				break;
			} else if (temp.next == null) {
				p.next = temp;
				break;
			}
			p.next = temp.next;
			p = temp;
		}
		return new_start;
	}

	public void swap_nodes(Node ahead, int x, int y) {
		if (x == y)
			return;

		Node prevX = null, currX = ahead;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}
		Node prevY = null, currY = ahead;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (currX == null || currY == null)
			return;
		if (prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}
		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}

		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

	}

	Node mergeSort(Node h) {
		if (h == null || h.next == null) {
			return h;
		}
		Node middle = getMiddle(h);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		Node left = mergeSort(h);
		Node right = mergeSort(nextOfMiddle);
		Node sortedList = sortedMerge(left, right);
		return sortedList;
	}

	private Node getMiddle(Node h) {
		if (h == null) {
			return h;
		}
		Node fast = h;
		Node slow = h;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.data >= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	Node getTail(Node cur) {
		while (cur != null && cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}

	Node partition(Node head, Node end, Node newHead, Node newEnd) {
		Node pivot = end;
		Node prev = null, cur = head, tail = pivot;
		while (cur != pivot) {
			if (cur.data < pivot.data) {
				if (newHead == null)
					newHead = cur;
				prev = cur;
				cur = cur.next;
			} else {
				if (prev != null)
					prev.next = cur.next;
				Node temp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = temp;
			}
		}

		if (newHead == null)
			newHead = pivot;

		newEnd = tail;
		return pivot;
	}

	Node quickSortRec(Node head, Node end) {
		if (head == null || head == end)
			return head;
		Node newHead = null, newEnd = null;
		Node pivot = partition(head, end, newHead, newEnd);

		if (newHead != pivot) {
			Node temp = newHead;
			while (temp.next != pivot) {
				temp = temp.next;
				temp.next = null;

				newHead = quickSortRec(pivot.next, newEnd);

				temp = getTail(newHead);
				temp.next = pivot;
			}

		}
		pivot.next = quickSortRec(pivot.next, newEnd);
		return newHead;
	}

	void quickSort(Node head) {
		head = quickSortRec(head, getTail(head));
		return;
	}
}

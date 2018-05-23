package models.stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ulan
 */
public class Stack {
	Node top;

	public Node peek() {
		if (top != null)
			return top;
		return null;

	}

	public Node pop() {
		if (top == null) {
			return null;
		} else {
			Node temp = new Node(top.data);
			top = top.next;
			return temp;
		}
	}

	public void push(Node n) {
		if (n != null) {
			n.next = top;
			top = n;
		}
	}
}

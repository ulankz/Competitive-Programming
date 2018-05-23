/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.queue;

/**
 *
 * @author Ulan
 */
public class Queue {
	Node first, last;

	public void enqueue(Node n) {
		if (first == null) {
			first = n;
			last = first;
		} else {
			first.next = n;
			last = n;
		}
	}

	public Node dequeue() {
		if (first == null) {
			return null;
		} else {
			Node temp = new Node(first.data);
			first = first.next;
			return temp;
		}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.stack;

/**
 *
 * @author Ulan
 */
public class Node {
	Node next;
	int data;

	Node(int data) {
		this.next = null;
		this.data = data;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Ulan
 */
public class Node {
    int data;
    Node next;
    Node(int data){
        this.next = null;
        this.data = data;
    }
}

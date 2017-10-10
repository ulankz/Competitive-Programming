/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist.implementation;

/**
 *
 * @author Ulan
 */
public class LinkedListImplementation {

  public static void main(String args[]){
      LinkedList l = new LinkedList();
      l.push(30);
      l.push(15);
      l.push(9);
      l.push(6);
      l.push(3);
      
    
      LinkedList ll = new LinkedList();
      
      ll.push(30);
      ll.push(15);
      ll.push(9);
      ll.push(6);
      ll.push(3);
      l.printList();
      ll.printList();
       LinkedList swapList = new LinkedList();
       swapList.head = swapList.swap_pairs(ll.head);
       swapList.printList();
      
  } 
    
}

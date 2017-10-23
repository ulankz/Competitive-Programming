/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularLinkedList;

/**
 *
 * @author Ulan
 */
public class CircularLinkedList {
    class Node{
        Node next;
        int data;
        Node(int data){
        this.data = data;
        this.next = null;
        }
    }
    void printList(Node node){
        Node temp = node;
        if( node != null ){
            do{
                System.out.print(temp.data + " ");
            temp = temp.next;
            }
            while(temp != node);
        }
        System.out.println();
    }
    Node addToEmpty(Node last, int data){
     if(last != null)
         return last;
         last = new Node(data);
         last.next = last;
         return last;
    }
    Node addBegin(Node last,int data){
        if(last == null){
            return addToEmpty(last, data);
        }
        Node n_node = new Node(data);
        n_node.next = last.next;
        last.next = n_node;
        return last;
    }
    Node addEnd(Node last, int data){
        if(last == null){
            addToEmpty(last, data);
        }
        Node n_node = new Node(data);
        n_node.next = last.next;
        last.next = n_node;
        last = n_node;
        return last;
    }
    Node addAfter(Node last, int data,int item){
        if(last == null){
            return null;
        }
        Node new_node, start_node;
        start_node = last.next;
        do{
            if(start_node.data == item){
            new_node = new Node(data);
            
            new_node.next = start_node.next;
            start_node.next = new_node;
            if(start_node == last)
                last = new_node;
            
            return last;
            }
            start_node = start_node.next;
        }
        while(start_node != last.next);
        System.out.println("Item is not present in the list");
        return last;
    }
    public static void main(String args[]){
        CircularLinkedList cl = new CircularLinkedList();
        Node last = null;
        last =cl.addToEmpty(last, 6);
        last =cl.addBegin(last, 9);
        last =cl.addBegin(last, 89);
        last =cl.addEnd(last, 49);
        last =cl.addEnd(last, 6);
        cl.printList(last);
     
    }
    
}

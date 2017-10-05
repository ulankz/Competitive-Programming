class LinkedList{
  Node head;
  class Node{
    int data;
    Node next;
    Node(int data){
      this.data = data;
      this.next = null;
    }
  }
  void swapNodes(int x , int y){
    if(x == y)
      return;
      Node prevX = null, curX = head;
      while(curX != null && curX.data != x){
        prevX = curX;
        curX = curX.next;
      }
      Node prevY = null, curY = head;
      while(curY != null && curY.data != y){
        prevY = curY;
        curY = curY.next;
      }

      if(curX == null || curY == null)
        return;
      if(prevX != null){
          prevX.next = curY;
      }
      else{
        head = curY;
      }
      if(prevY != null){
          prevY.next = curX;
      }
      else{
        head = curX;
      }

      Node temp = curX.next;
      curX.next = curY.next;
      curY.next = temp;
  }
  public void push(int new_data){
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }
  public void printList(){
    Node tNode = head;
    while(tNode != null){
      System.out.print(tNode.data + " ");
      tNode = tNode.next;
    }
    System.out.println();
  }

}

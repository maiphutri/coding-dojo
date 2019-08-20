public class SinglyLinkedList {
  public Node head;
  public SinglyLinkedList() {
    this.head = null;
  }
  // SLL methods go here. As a starter, we will show you how to add a node to the list.
  public void add(int value) {
    Node newNode = new Node(value);
    if(head == null) {
        head = newNode;
    } else {
        Node runner = head;
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
    }
  }

  public void remove() {
    if (this.head == null) {
      System.out.println("Error! Empty Linked List");
    } 
    if (this.head.next == null) {
      this.head = null;
    } else {
      Node current = this.head;
      Node prev = this.head;
      while(current.next != null) {
        prev = current;
        current = current.next;
      }
      prev.next = null;
    }
  }

  public void printValues() {
    if (this.head == null) {
      System.out.println("Error! Empty Linked List");
    } else {
      Node current = head;
      while(current != null) {
        System.out.println(current.value);
        current = current.next;
      }
    }
  }

  public Node find(int value) {
    Node notFound = new Node(-1);
    if (this.head == null) {
      System.out.println("Error! Empty Linked List");
      return notFound;
    }
    Node current = this.head;
    while (current != null) {
      if (current.value == value) {
        return current;
      }
      current = current.next;
    }
    return notFound;
  }

  public void removeAt(int i) {
    int count = 0;
    Node current = this.head;
    Node prev = this.head;
    while (count < i) {
      prev = current;
      current = current.next;
      count++;
    }
    if (i == 0) {
      this.head = current.next;
    } else {
      prev.next = current.next;
    }
    
  }
}
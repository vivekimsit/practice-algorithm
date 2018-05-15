class LinkedListNode {

  public String value;
  public LinkedListNode next;

  public LinkedListNode(String value) {
    this.value = value;
  }
}

class DeleteNodeLinkedList {
  static void deleteNode(LinkedListNode node) {
    LinkedListNode current = node;

    if (current.next != null) {
      current.value = current.next.value;
      current.next  = current.next.next;
    }

    // A -> B -> C -> null
    //    curr  next
    // A -> C -> null
    //    curr
  }

  static void print(LinkedListNode node) {
    LinkedListNode current = node;

    while (current != null) {
      System.out.print(current.value);
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListNode a = new LinkedListNode("A");
    LinkedListNode b = new LinkedListNode("B");
    LinkedListNode c = new LinkedListNode("C");

    a.next = b;
    b.next = c;

    print(a);
    deleteNode(b);
    print(a);
  }
}
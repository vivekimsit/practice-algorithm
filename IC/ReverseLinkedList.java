class LinkedListNode {

  public int value;
  public LinkedListNode next;

  public LinkedListNode(int value) {
    this.value = value;
  }
}

class ReverseLinkedList {
  static LinkedListNode solve(LinkedListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // here list has at least two nodes
    LinkedListNode prev = null;
    LinkedListNode next = null;
    LinkedListNode current = head;

    while (current != null) {
      next = current.next;

      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  static void print(LinkedListNode head) {
    LinkedListNode current = head;
    while (current != null) {
      System.out.print(current.value);
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);

    print(solve(null));
    print(solve(new LinkedListNode(1)));

    head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    print(solve(head));
  }
}

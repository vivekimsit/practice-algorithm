class LinkedListNode {

  public String value;
  public LinkedListNode next;

  public LinkedListNode(String value) {
    this.value = value;
  }
}

class KthToLastNode {
  static LinkedListNode solve(int position, LinkedListNode head) {
    if (head == null) {
      return head;
    }
    LinkedListNode fast = head;
    LinkedListNode slow = head;

    for (int i = 0; (i < position - 1) && fast != null; i++) {
      fast = fast.next;
    }

    if (fast == null) {
      throw new IllegalArgumentException("position is larger than the list");
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  static void print(LinkedListNode head) {
    LinkedListNode current = head;
    while (current != null) {
      System.out.print(current.value + " ");
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListNode a = new LinkedListNode("Angel Food");
    LinkedListNode b = new LinkedListNode("Bundt");
    LinkedListNode c = new LinkedListNode("Cheese");
    LinkedListNode d = new LinkedListNode("Devil's Food");
    LinkedListNode e = new LinkedListNode("Eccles");

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    print(solve(1, a));
    print(solve(2, a));
    print(solve(5, a));
    print(solve(6, a));
  }
}

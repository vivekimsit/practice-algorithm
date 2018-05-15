class LinkedListNode {
  public int value;
  public LinkedListNode next;

  public LinkedListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycle {
  static boolean containsCycle(LinkedListNode head) {
    LinkedListNode slower = head;
    LinkedListNode faster = head;

    while (faster != null && faster.next != null) {
      slower = slower.next;
      faster = faster.next.next;

      if (slower == faster) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    head.next.next = new LinkedListNode(3);
    head.next.next = head;

    System.out.println(containsCycle(null));
    System.out.println(containsCycle(new LinkedListNode(1)));

    System.out.println(containsCycle(head));
  }
}
import java.util.*;


class ListNode {
  int val;
  ListNode next;
  ListNode rand;
  ListNode(int x) {
    val = x;
  }
}

/**
 *  1 -> 2 -> 3 -> null
 *  |    |    |
 *  1 -> 2 -> 3 -> null
 */
class Main {
  private static ListNode copyList(ListNode head) {
    if (head == null) {
      return head;
    }
    Map<ListNode, ListNode> map = new HashMap<>();
    ListNode origin = head;
    // put node pairs in the map
    while (origin != null) {
      ListNode node = new ListNode(origin.val);
      map.put(origin, node);

      origin = origin.next;
    }

    //{N1: N11, N2: N22}
    ListNode dummy  = new ListNode(0);
    ListNode result = dummy;
    for (Map.Entry<ListNode, ListNode> entry : map.entrySet()) {
      ListNode orig = entry.getKey();
      ListNode copy = entry.getValue();

      copy.next = map.get(orig.next);
      copy.rand = map.get(orig.rand);
      result.next = copy;
      result = result.next;
    }
    return dummy.next;
  }

  private static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    print(copyList(null));

    ListNode head = new ListNode(1);
    print(copyList(head));

    head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.rand = head;
    head.rand = head.next.next;
    print(copyList(head));
  }
}
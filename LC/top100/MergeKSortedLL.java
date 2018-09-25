import java.util.*;

class MergeKSortedLL {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists==null || lists.length == 0) return null;


    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
      public int compare(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
      }
    });
    for (ListNode node : lists) {
      if (node != null) {
        pq.add(node);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode tail  = dummy;
    while (!pq.isEmpty()) {
      tail.next = pq.poll();
      tail = tail.next;
      if (tail.next != null) pq.add(tail.next);
    }
    return dummy.next;
  }
}

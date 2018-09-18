import java.util.*;

public class LinkedListIntersection {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int countA = countNodes(headA);
    int countB = countNodes(headB);
    int diff = Math.abs(countA - countB);
    return countA > countB ?  getIntersectionNode(diff, headA, headB) : getIntersectionNode(diff, headB, headA);
  }

  private int countNodes(ListNode head) {
    int count = 0;
    while (head != null) {
      head = head.next;
      count++;
    };
    return count;
  }

  private ListNode getIntersectionNode(int diff, ListNode headA, ListNode headB) {
    for (int i = 0; i < diff; i++) {
      if (headA == null) return null;
      headA = headA.next;
    }
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }
}

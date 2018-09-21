import java.util.*;

class PalindromeLL {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) slow = slow.next;

    slow = reverse(slow);
    fast = head;
    while (slow != null) {
      if (fast.val != slow.val) return false;
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }
    return prev;
  }
}

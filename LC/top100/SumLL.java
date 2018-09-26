import java.util.*;

class SumLL {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    int sum = 0;
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (l1 != null || l2 != null) {
      sum += carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      carry = sum / 10;
      sum = sum % 10;
      head.next = new ListNode(sum);
      head = head.next;
      sum = 0;
    }
    if (carry > 0) head.next = new ListNode(carry);
    return dummy.next;
  }
}

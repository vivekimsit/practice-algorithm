import java.util.*;


class ListNode {
  ListNode next;
  int val;

  ListNode(int val) {
    this.val = val;
  }
}

class LinkedList {
  ListNode head;

  void append(int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
      head = newNode;
      return;
    }
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }

  void print() {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val);
      current = current.next;
    }
    System.out.println();
  }
}

class LinkedListReversePairs {
  ListNode head;

  public LinkedListReversePairs(ListNode head) {
    this.head = head;
  }

  public void execute() {
    if (head == null || head.next == null) {
      throw new IllegalArgumentException();
    }
    ListNode current = head;
    ListNode runner;

    while (current != null && current.next != null) {
      runner = current.next;

      int temp = current.val;
      current.val = runner.val;
      runner.val = temp;

      current = runner.next;
      //runner  = current.next;
    }
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.print();

    LinkedListReversePairs algo = new LinkedListReversePairs(list.head);
    algo.execute();
    list.print();

    System.out.println();
    LinkedList odd = new LinkedList();
    odd.append(1);
    odd.append(2);
    odd.append(3);
    odd.print();

    System.out.println();
    algo = new LinkedListReversePairs(odd.head);
    algo.execute();
    odd.print();

    failureCases();
  }

  public static void failureCases() {
    try {
      LinkedListReversePairs algo = new LinkedListReversePairs(null);
      algo.execute();
      System.out.println("Failed");
    } catch(IllegalArgumentException ie) {
      System.out.println("Passed");
    }

    try {
      LinkedList list = new LinkedList();
      list.append(1);
      LinkedListReversePairs algo = new LinkedListReversePairs(list.head);
      algo.execute();
      System.out.println("Failed");
    } catch(IllegalArgumentException ie) {
      System.out.println("Passed");
    }
  }
}

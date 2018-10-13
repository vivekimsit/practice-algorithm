import java.util.*;


class InorderSuccessorBT {
  private static BinaryTreeNode successor(BinaryTreeNode root, BinaryTreeNode node) {
    if (root == null || node == null) { return null; }

    if (node.right != null) {
      return leftmost(node.right);
    } else {
      BinaryTreeNode parent  = node.parent;
      BinaryTreeNode current = node;
      while (parent != null && parent.left != current) {
        current = parent;
        parent  = parent.parent;
      }
      return parent;
    }
  }

  private static BinaryTreeNode leftmost(BinaryTreeNode root) {
    BinaryTreeNode current = root;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(10);
    BinaryTreeNode left = root.left(5);
    left.parent = root;
    BinaryTreeNode right = root.right(30);
    right.parent = root;

    BinaryTreeNode rightLeft = right.left(22);
    rightLeft.parent = right;
    BinaryTreeNode rightLeftRight = rightLeft.right(25);
    rightLeftRight.parent = rightLeft;
    BinaryTreeNode rightRight = right.right(35);
    rightRight.parent = right;

    System.out.println(successor(root, root)); // 10 -> 22
    System.out.println(successor(root, left)); // 5  -> 10
    System.out.println(successor(root, rightLeft)); // 22 -> 25
    System.out.println(successor(root, rightLeftRight)); // 25 -> 30
  }
}

class BinaryTreeNode {
  public int val;
  public BinaryTreeNode left;
  public BinaryTreeNode right;
  public BinaryTreeNode parent;

  public BinaryTreeNode(int val) {
    this.val = val;
  }

  public BinaryTreeNode left(int leftValue) {
    this.left = new BinaryTreeNode(leftValue);
    return this.left;
  }

  public BinaryTreeNode right(int rightValue) {
    this.right = new BinaryTreeNode(rightValue);
    return this.right;
  }

  public String toString() {
    return "Node(" + this.val + ")";
  }
}

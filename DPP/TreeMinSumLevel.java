import java.util.*;

class TreeMinSumLevel {
  private static int findMinSumLevel(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int currentLevel = 0, level = 0;
    int minSum = Integer.MAX_VALUE;
    Queue<BinaryTreeNode> seen = new LinkedList<>();
    seen.add(root);
    while(!seen.isEmpty()) {
      int sum = 0;
      int size = seen.size();
      for (int i = 0; i < size; i++) {
        BinaryTreeNode current = seen.poll();
        sum += current.value;
        if (current.left != null) {
          seen.add(current.left);
        }
        if (current.right != null) {
          seen.add(current.right);
        }
      }
      if (sum < minSum) {
        level  = currentLevel;
        minSum = sum;
      }
      currentLevel++;
    }
    return level;
  }

  public static void main(String[] args) {
    BinaryTreeNode root  = new BinaryTreeNode(1);
    BinaryTreeNode left  = root.insertLeft(2);
    left.insertLeft(4).insertLeft(8);
    left.insertRight(5);
    BinaryTreeNode right = root.insertRight(3);
    right.insertLeft(6);
    right.insertRight(7);

    System.out.println(findMinSumLevel(null)); // 0
    System.out.println(findMinSumLevel(root)); // 0

    BinaryTreeNode leftSkewed  = new BinaryTreeNode(1);
    leftSkewed.insertLeft(-1).insertLeft(-2);
    System.out.println(findMinSumLevel(leftSkewed)); // 2
  }
}


class BinaryTreeNode {
  public int value;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int value) {
      this.value = value;
  }

  public BinaryTreeNode insertLeft(int leftValue) {
      this.left = new BinaryTreeNode(leftValue);
      return this.left;
  }

  public BinaryTreeNode insertRight(int rightValue) {
      this.right = new BinaryTreeNode(rightValue);
      return this.right;
  }

  public String toString() {
    return "Node (" + this.value + ")";
  }
}
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
}

/**
 *
 * The current implementation uses space equivalent to depth
 * of the tree which in worst case can be equal to number
 * of nodes in the tree (tree is a straight line) otherwise
 * its equal to the height of the tree O(h) which is in a balanced
 * tree is O(logn)
 *
 * If we need to solve it in space efficient manner we can do
 * an inorder traversal and it should be sorted.
 */
class ValidBinarySearchTree {
  static boolean isBST(BinaryTreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   *
   * Below is the pre-order traversal of the tree.
   * Pre-order makes sense here because we don't want to do the
   * computation for left and right if the root of each sub tree is not correct itself.
   */
  private static boolean isBST(BinaryTreeNode root, int min, int max) {
    if (root == null) return true;

    return min < root.value && root.value < max &&
           isBST(root.left, min, root.value) &&
           isBST(root.right, root.value, max);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(3);
    root.insertLeft(2).insertLeft(1);
    root.insertRight(4).insertRight(5);

    BinaryTreeNode leftSkewed = new BinaryTreeNode(3);
    leftSkewed.insertLeft(2).insertLeft(1);
    System.out.println(isBST(leftSkewed));

    // Valid BSTs
    System.out.println(isBST(null));
    System.out.println(isBST(root));

    // Invalid BSTs
    BinaryTreeNode invalid = new BinaryTreeNode(2);
    root.insertLeft(3);
    root.insertRight(1);
    System.out.println(isBST(root));
  }
}


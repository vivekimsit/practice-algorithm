import java.util.*;

class HouseRobber {
  public int rob(TreeNode root) {
    if (root == null) return 0;

    int num1 = root.val;
    if (root.left  != null) {
      num1 += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      num1 += rob(root.right.left) + rob(root.right.right);
    }
    int num2 = rob(root.left) + rob(root.right);
    return Math.max(num1, num2);
  }
}

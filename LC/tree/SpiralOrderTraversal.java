import java.util.*;

class SpiralOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    Stack<TreeNode> even = new Stack<>();
    Stack<TreeNode> odd  = new Stack<>();
    even.push(root);
    while (!even.isEmpty() || !odd.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      while (!even.isEmpty()) {
        TreeNode current = even.pop();
        level.add(current.val);
        if (current.left != null) {
          odd.push(current.left);
        }
        if (current.right != null) {
          odd.push(current.right);
        }
      }
      if (!level.isEmpty()) result.add(level);

      level = new ArrayList<>();
      while (!odd.isEmpty()) {
        TreeNode current = odd.pop();
        level.add(current.val);
        if (current.right != null) {
          even.push(current.right);
        }
        if (current.left != null) {
          even.push(current.left);
        }
      }
      if (!level.isEmpty()) result.add(level);
    }
    return result;
  }
}

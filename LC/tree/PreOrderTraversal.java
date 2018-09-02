import java.util.*;

public class PreOrderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(TreeNode root, List<Integer> rsf) {
    if (root != null) {
      rsf.add(root.val);
      dfs(root.left,  rsf);
      dfs(root.right, rsf);
    }
  }
}

class PreOrderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}

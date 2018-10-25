import java.util.*;

class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public void print() {
    //System.out.println();
    print(this);
    System.out.println();
  }

  private void print(TreeNode root) {
    if (root != null) {
      print(root.left);
      System.out.print(root.val);
      print(root.right);
    }
  }
}

class PruneTree {
  private TreeNode root;

  public PruneTree(List<Integer> items) {
    createBinaryTree(items);
  }

  public TreeNode execute() {
    return prune(root);
  }

  private TreeNode prune(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left  = prune(root.left);
    TreeNode right = prune(root.right);
    if (left == null) {
      root.left  = null;
    }
    if (right == null) {
      root.right = null;
    }
    if (left == null && right == null && root.val == 0) {
      return null;
    }
    return root;
  }

  private void createBinaryTree(List<Integer> items) {
    if (items.size() == 0)  {
      throw new IllegalArgumentException("The input array is null.");
    }

    root = new TreeNode(items.get(0));
    final Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    final int half = items.size() / 2;
    for (int i = 0; i < half; i++) {
      if (items.get(i) == null) {
        continue;
      }
      final TreeNode current = queue.poll();
      final int left = 2 * i + 1;
      final int right = 2 * i + 2;

      if (items.get(left) != null) {
        current.left = new TreeNode(items.get(left));
        queue.add(current.left);
      }
      if (right < items.size() && items.get(right) != null) {
        current.right = new TreeNode(items.get(right));
        queue.add(current.right);
      }
    }
  }
}

class Main {
  public static void main(String[] args) {
    //new PruneTree(Arrays.asList(0))
      //.execute()
      //.print(); // This will throw
    new PruneTree(Arrays.asList(1))
      .execute()
      .print();
    new PruneTree(Arrays.asList(1, 0, 0))
      .execute()
      .print();
    new PruneTree(Arrays.asList(1, null, 0, null, null, 0, 1))
      .execute()
      .print();
    new PruneTree(Arrays.asList(0, 1, 0, null, null, 1, 0))
      .execute()
      .print();
  }
}

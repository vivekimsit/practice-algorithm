import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


class BinaryTreeNode {
  public int value;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  BinaryTreeNode(final int value) {
    this.value = value;
  }

  BinaryTreeNode insertLeft(final int value) {
    this.left = new BinaryTreeNode(value);
    return this.left;
  }

  BinaryTreeNode insertRight(final int value) {
    this.right = new BinaryTreeNode(value);
    return this.right;
  }
}

class NodeDepth {
  public BinaryTreeNode node;
  public int depth;

  NodeDepth(final BinaryTreeNode node, final int depth) {
    this.node  = node;
    this.depth = depth;
  }
}

public class BalancedBinaryTree {
  static boolean solve(BinaryTreeNode root) {
    if (root == null) return true;

    Stack<NodeDepth> nodes = new Stack<>();
    nodes.push(new NodeDepth(root, 0));
    List<Integer> depths = new ArrayList<>(3);

    while (!nodes.empty()) {
      NodeDepth nodeDepth = nodes.pop();
      BinaryTreeNode node = nodeDepth.node;

      int depth = nodeDepth.depth;
      if (isLeaf(node)) {
        if (!depths.contains(depth)) {
          depths.add(depth);

          if (depths.size() > 2 ||
              (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
            return false;
          }
        }
      } else {
        if (node.left != null) {
          nodes.push(new NodeDepth(node.left, depth + 1));
        }
        if (node.right != null) {
          nodes.push(new NodeDepth(node.right, depth + 1));
        }
      }
    }
    return true;
  }

  private static boolean isLeaf(BinaryTreeNode node) {
    return node.left == null && node.right == null;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(2);
    root.insertLeft(1);
    root.insertLeft(3);
    System.out.println(solve(root));

    BinaryTreeNode unbalanced = new BinaryTreeNode(2);
    unbalanced.insertLeft(1).insertLeft(3).insertLeft(5);
    System.out.println(solve(unbalanced));
  }
}

import java.util.*;

class LevelOrderTraversalII {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) return levels;

    Queue<Node> seen = new LinkedList<>();
    seen.add(root);
    while (!seen.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = seen.size();
      for (int i = 0; i < size; i++) {
        Node current = seen.poll();
        level.add(current.val);
        for (Node node: current.children) {
          seen.add(node);
        }
      }
      levels.add(level);
    }
    return levels;
  }
}

import java.util.*;

class TrieNode {
  TrieNode[] keys = new TrieNode[256];
  Object val;
}

class TrieST<Value> {
  private TrieNode root;
  private int keys;

  public void put(String key, Value val) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    root = put(root, key, val, 0, " ");
  }

  public TrieNode put(TrieNode root, String key, Value val, int depth, String indent) {
    //System.out.println(indent + "put(" + depth + ")");
    if (root == null) root = new TrieNode();
    if (depth == key.length()) {
      if (root.val == null) keys++;
      root.val = val;
      return root;
    }
    char ch = key.charAt(depth);
    root.keys[ch] = put(root.keys[ch], key, val, depth + 1, indent+indent);
    return root;
  }

  public Value get(String key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    TrieNode node = get(root, key, 0);
    if (node == null) return null;
    return (Value) node.val;
  }

  public TrieNode get(TrieNode root, String key, int depth) {
    if (root == null) return null;
    if (depth == key.length()) return root;
    char ch = key.charAt(depth);
    return get(root.keys[ch], key, depth + 1);
  }

  public boolean contains(String key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    return get(key) != null;
  }

  public Iterable<String> keysWithPrefix(String prefix) {
    Queue<String> results = new LinkedList<>();
    TrieNode x = get(root, prefix, 0);
    collect(x, new StringBuilder(prefix), results);
    return results;
  }

  public int size() {
    return keys;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  private void collect(TrieNode x, StringBuilder prefix, Queue<String> results) {
    if (x == null) return;
    if (x.val != null) results.add(prefix.toString());
    for (char c = 0; c < 256; c++) {
      prefix.append(c);
      collect(x.keys[c], prefix, results);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
}

class MapSum {
    private final TrieST<Integer> st;

    /** Initialize your data structure here. */
    public MapSum() {
        st = new TrieST<>();
    }

    public void insert(String key, int val) {
        st.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String s : st.keysWithPrefix(prefix)) {
          sum += st.get(s);
        }
        return sum;
    }
}

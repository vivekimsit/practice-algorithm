import java.util.*;

class FindWordMatrix {
  private static boolean searchWord(char[][] matrix, String word) {
    int R = matrix.length;
    int C = matrix[0].length;
    boolean[][] visited = new boolean[R][C];

    boolean seen = false;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (!seen && matrix[i][j] == word.charAt(0)) {
          seen = dfs(matrix, i, j, word, 0, visited, " ");
        }
      }
    }
    return seen;
  }

  private static boolean dfs(
      char[][] matrix, int i, int j, String w, int pos, boolean[][] visited, String indent) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
      return false;
    }
    //System.out.println(indent + i + " : " + j);
    if (visited[i][j]) {
      return false;
    }
    if (matrix[i][j] != w.charAt(pos)) {
      return false;
    }
    if (pos == w.length() - 1) {
      return true;
    }
    visited[i][j] = true;
    boolean seen =
      dfs(matrix, i - 1, j, w, pos + 1, visited, indent + indent) || // top
      dfs(matrix, i, j + 1, w, pos + 1, visited, indent + indent) || // right
      dfs(matrix, i + 1, j, w, pos + 1, visited, indent + indent) || // bottom
      dfs(matrix, i, j - 1, w, pos + 1, visited, indent + indent);   // left

    visited[i][j] = false;
    return seen;
      }

  public static void main(String[] args) {
    System.out.println(searchWord(new char[][] {
      {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    }, "SEE"));
    System.out.println(searchWord(new char[][] {
      {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    }, "ABCCED"));
    System.out.println(searchWord(new char[][] {
      {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    }, "ABCB"));
  }
}

import java.util.*;

class ReplaceColors {
  char[][] grid;
  boolean[][] visited;

  ReplaceColors(char[][] grid) {
    int R = grid.length;
    int C = grid[0].length;
    this.grid = new char[R][C];
    visited = new boolean[R][C];
    for (int x = 0; x < grid.length; x++) {
      this.grid[x] = grid[x].clone();
    }
  }

  char[][] solve(int x, int y, char color) {
    dfs(grid[x][y], color, x, y, grid.length, grid[0].length);
    return grid;
  }

  void dfs(char source, char target, int x, int y, int R, int C) {
    //if (x < 0 || x >= R || y < 0 || y >= C) {
      //return;
    //}
    if (visited[x][y] == true) {
      return;
    }
    if (grid[x][y] == source) {
      grid[x][y] = target;
    }
    visited[x][y] = true;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) continue;
        int r = x + i;
        int c = y + j;
        if (0 <= r && r < R && 0 <= c && c < C && grid[r][c] == source) {
          dfs(source, target, r, c, R, C);
        }
      }
    }
  }
}

class Main {
  public static void main(String[] args) {
    char[][] grid = new char[][]{
      {'B', 'B', 'W'},
      {'W', 'W', 'W'},
      {'W', 'W', 'W'},
      {'B', 'B', 'B'}
    };
    System.out.println(Arrays.deepToString(new ReplaceColors(new char[][]{
      {'B'},
      {'B'}
    }).solve(1, 0, 'B')));
    System.out.println(
      Arrays.deepToString(new ReplaceColors(grid).solve(2, 2, 'G')));
    System.out.println(
      Arrays.deepToString(new ReplaceColors(grid).solve(3, 0, 'G')));
    System.out.println(
      Arrays.deepToString(new ReplaceColors(grid).solve(0, 0, 'G')));
  }
}

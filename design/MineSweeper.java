import java.util.*;

class MineSweeper {

  public char[][] updateBoard(char[][] board, int[] click) {
    int ROW = board.length;
    int COL = board[0].length;
    updateNeighbours(board, click[0], click[1], ROW, COL);
    return board;
  }

  private void updateNeighbours(char[][] board, int row, int col, int rows, int cols) {
    if (board[row][col] == 'M') {
      board[row][col] = 'X';
      return;
    }

    int count = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) continue;

        int r = row + i;
        int c = col + j;
        if (-1 < r && r < rows && -1 < c && c < cols) {
          char status = board[r][c];
          if (status == 'M' || status == 'X') {
            count++;
          }
        }
      }
    }
    if (count > 0) {
      board[row][col] = Character.forDigit(count, 10);
    } else {
      board[row][col] = 'B';
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i == 0 && j == 0) continue;

          int r = row + i;
          int c = col + j;
          if (-1 < r && r < rows && -1 < c && c < cols) {
            char status = board[r][c];
            if (status == 'E') {
              updateNeighbours(board, r, c, rows, cols);
            }
          }
        }
      }
    }
  }
}

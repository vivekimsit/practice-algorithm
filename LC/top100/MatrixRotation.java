import java.util.*;

class Solution {
  public void rotate(int[][] arr) {
    int n = arr.length;

    for (int c = 0; c < n / 2; ++c) {
      int l = n - 1 - c;

      for (int i = 0; i < l - c; ++i) {
        int temp = arr[l-i][c];

        arr[l - i][c] = arr[l][l - i];
        arr[l][l - i] = arr[c+i][l];
        arr[c+i][l] = arr[c][c+i];
        arr[c][c+i] = temp;
      }
    }
  }
}

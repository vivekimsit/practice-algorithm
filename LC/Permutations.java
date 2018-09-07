import java.util.*;

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    dfs(nums, permutations, new ArrayList<>()/*, " "*/);
    return permutations;
  }

  private void dfs(int[] nums, List<List<Integer>> permutations, List<Integer> path/*, String indent*/) {
    //System.out.println(indent + path);
    if (path.size() == nums.length) {
      permutations.add(new ArrayList<>(path));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (path.contains(nums[i])) continue;

        path.add(nums[i]);
        dfs(nums, permutations, new ArrayList<>(path)/*, indent + indent*/);
        path.remove(path.size() - 1);
      }
    }
  }
}

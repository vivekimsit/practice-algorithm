import java.util.*;

class ContainsDuplicate {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> seen = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      if (seen.containsKey(nums[i])) {
        if (i - seen.get(nums[i]) <= k) return true;
      }
      seen.put(nums[i], i);
    }
    return false;
  }
}

import java.util.*;

class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int N = s.length();
        int[] cache = new int[N+1];
        for (int i = 0; i <= N; i++) {
            cache[i] = -1;
        }
        return numWays(s, 0, cache);
    }

    private int numWays(String s, int consumed, int[] cache) {
        if (consumed < s.length() && s.charAt(consumed) == '0') {
            return 0;
        }
        if (consumed == s.length()) {
            return 1;
        }
        if (cache[consumed] != -1) {
            return cache[consumed];
        }
        int ways = numWays(s, consumed + 1, cache);
        int num = 0;
        if (consumed + 1 < s.length()) {
            num = Integer.parseInt(s.substring(consumed, consumed + 2));
        }
        if (num >= 10 && num <= 26) {
            ways += numWays(s, consumed + 2, cache);
        }
        cache[consumed] = ways;
        return cache[consumed];
    }
}

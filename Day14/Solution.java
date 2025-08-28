import java.util.*;

class Solution {
    public int countSubstringsWithKDistinct(String s, int k) {
        if (k > s.length()) return 0;  // edge case
        return countAtMost(s, k) - countAtMost(s, k - 1);
    }

    private int countAtMost(String s, int k) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }

            // all substrings ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countSubstringsWithKDistinct("pqpqs", 2)); // 7
        System.out.println(sol.countSubstringsWithKDistinct("aabacbebebe", 3)); // 10
        System.out.println(sol.countSubstringsWithKDistinct("a", 1)); // 1
        System.out.println(sol.countSubstringsWithKDistinct("abc", 3)); // 1
        System.out.println(sol.countSubstringsWithKDistinct("abc", 2)); // 2
    }
}

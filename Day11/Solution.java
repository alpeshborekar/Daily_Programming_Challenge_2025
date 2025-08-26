import java.util.*;

public class Solution {
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(char[] chars, StringBuilder path, boolean[] used, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // skip if already used
            if (used[i]) continue;
            // skip duplicates: if same char and previous not used, skip
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.append(chars[i]);
            backtrack(chars, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique("abc"));   // [abc, acb, bac, bca, cab, cba]
        System.out.println(permuteUnique("aab"));   // [aab, aba, baa]
        System.out.println(permuteUnique("aaa"));   // [aaa]
        System.out.println(permuteUnique("a"));     // [a]
        System.out.println(permuteUnique("abcd"));  // 24 permutations
    }
}

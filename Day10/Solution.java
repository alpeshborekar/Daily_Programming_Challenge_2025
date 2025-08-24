import java.util.*;

public class Solution{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));

        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(groupAnagrams(strs4));

        String[] strs5 = {"abc", "def", "ghi"};
        System.out.println(groupAnagrams(strs5));
    }
}

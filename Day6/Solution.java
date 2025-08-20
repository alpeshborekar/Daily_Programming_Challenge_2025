import java.util.*;

public class Solution {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(0L, new ArrayList<>(Arrays.asList(-1)));
        long prefix = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            if (map.containsKey(prefix)) {
                for (int start : map.get(prefix)) {
                    result.add(new int[]{start + 1, i});
                }
                map.get(prefix).add(i);
            } else {
                map.put(prefix, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> res = findZeroSumSubarrays(arr);
        for (int[] p : res) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }
}

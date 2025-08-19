import java.util.*;

public class Solution {
    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders: " + findLeaders(arr));

        int[] arr2 = {7, 10, 4, 10, 6, 5, 2};
        System.out.println("Leaders: " + findLeaders(arr2));

        int[] arr3 = {1, 2, 3, 4, 0};
        System.out.println("Leaders: " + findLeaders(arr3));

        int[] arr4 = {100, 50, 20, 10};
        System.out.println("Leaders: " + findLeaders(arr4));

        int[] arr5 = {5};
        System.out.println("Leaders: " + findLeaders(arr5));
    }
}

public class Solution {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        long original_sum = (long) n * (n + 1) / 2;
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (int) (original_sum - sum);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int result = findMissingNumber(arr);
        System.out.println("Missing number is: " + result);
    }
}

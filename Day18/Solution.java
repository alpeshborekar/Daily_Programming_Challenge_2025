import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(countDivisors(n));
    }

    public static int countDivisors(long n) {
        int cnt = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) cnt++;
                else cnt += 2;
            }
        }
        return cnt;
    }
}

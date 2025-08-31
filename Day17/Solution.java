import java.util.*;

public class Solution {
    public static List<Long> primeFactorization(long N) {
        List<Long> factors = new ArrayList<>();
        while (N % 2 == 0) {
            factors.add(2L);
            N /= 2;
        }
        for (long i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                factors.add(i);
                N /= i;
            }
        }
        if (N > 1) factors.add(N);
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(primeFactorization(N));
    }
}

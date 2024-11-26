// Runtime 0 ms Beats 100.00% Analyze Complexity 
// Memory 40.33 MB Beats 42.12% Analyze Complexity

class Solution {
    // 조합
    public int climbStairs1(int n) {
        int sum = 0;
        for (int i = 0; i <= n / 2; i++) {
            int tot = i + (n - 2 * i);
            int num = Math.min(i, tot - i);

            double a = 1; // 분자
            double b = 1; // 분모
            for (int j = 0; j < num; j++) {
                a *= (tot - j);
                b *= (num - j);
            }

            sum += (a / b);
        }

        return sum;
    }

    // Memoization
    public int climbStairs2(int n) {
        int two = 0;
        int one = 1;
        int now = 0;

        for (int i = 0; i < n; i++) {
            now = two + one;

            two = one;
            one = now;
        }

        return now;
    }
}
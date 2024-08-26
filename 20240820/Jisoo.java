class Solution {
    public int reverse(int x) {
        double output = 0; // 출력값

        while (x != 0) {
            output = output * 10 + (x % 10);
            x /= 10;

            if (Math.abs(output) > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) output;
    }
}
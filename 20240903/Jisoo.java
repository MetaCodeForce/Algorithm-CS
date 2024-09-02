class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int a = x; // 원본
        int b = 0; // 뒤집은 수
        while (a > 0) {
            b = b * 10 + a % 10;
            a /= 10;
        }

        return x == b;
    }
}
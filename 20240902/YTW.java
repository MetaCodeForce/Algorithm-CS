class Solution {
    public boolean isPalindrome(int x) {

        // 어음펄(어차피음수는 false)
        if (x < 0)
            return false;

        // 변수 설정
        int digitCount = String.valueOf(x).length(); // input x의 자리수
        int origin_x = x; // 최초값 복사
        int result_palindromic = 0; // 결과값
        int mod = (int) Math.pow(10, digitCount - 1); // 자리수에 따라 나누는 수 구하기(ex:10^0, 10^1, 10^2 ...)
        int i = 1; // result_palindromic을 만들때 쓰이는 곱해지는 수 (ex:1, 10, 100, 1000 ...)

        // 로직
        while (mod != 0) {
            result_palindromic += (x / mod) * i;
            x -= mod * (x / mod);
            mod /= 10;
            i *= 10;
        }

        // 결과설정
        if (result_palindromic == origin_x)
            return true;
        else
            return false;
    }
}
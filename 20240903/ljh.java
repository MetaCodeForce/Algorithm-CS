class Solution {
    public boolean isPalindrome(int x) {
        // 문제를 보아하니 음수는 무조건 false.
        if(x < 0){
            return false;
        }

        // Palindrome은 거꾸로 해도 Palindrome
        // 가장 큰 자리부터 일의자리에 세팅해서 역순으로 만들고 그게 x랑 같으면 Palindrome
        int reverse=0;
        int temp=x;
        while(temp!=0){
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }
        return reverse == x;
    }

    // 투 포인터. 개념을 까먹었다면 노션을 확인하세요!
    public static String findPalind(String s, int left, int right) {
        while (left>=0 && right<s.length()) {
            if (s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            } else break;
        }
        return s.substring(++left, --right+1); // 해당 palindrome을 찾으려면 left, right 다시 돌아와야 함
    }
}
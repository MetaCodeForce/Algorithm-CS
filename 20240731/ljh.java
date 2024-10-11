class Solution {
    public String longestPalindrome(String s) {
        if (s==null || "".equals(s)) {
            return s;
        }

        String answer = s.substring(0,1);

        for (int i=0; i<s.length(); i++) {
            String sub1 = findPalind(s, i-1, i+1);
            String sub2 = findPalind(s, i, i+1);

            if (sub1.length() > answer.length()) {
                answer = sub1;
            }

            if (sub2.length() > answer.length()) {
                answer = sub2;
            }
        }

        return answer;
    }

    // 투 포인터로 팰린드롬을 찾았습니다. 개념을 까먹었다면 노션을 확인하세요!
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
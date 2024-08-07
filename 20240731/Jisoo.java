class Solution {
    public String longestPalindrome(String s) {
        String ans = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {

            int idx = s.indexOf(s.charAt(i), i + 1);

            while (idx > 0) {
                boolean palindrome = true;
                if (idx - i + 1 > ans.length()) {
                    int sNum = i;
                    int eNum = idx;
                    while (sNum < eNum && palindrome) {
                        if (s.charAt(sNum++) != s.charAt(eNum--))
                            palindrome = false;
                    }

                    if (palindrome)
                        ans = s.substring(i, idx + 1);
                }

                idx = s.indexOf(s.charAt(i), idx + 1);
            }
        }
        return ans;
    }
}
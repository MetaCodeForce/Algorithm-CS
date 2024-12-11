class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1 = text1.length();
        int len2 = text2.length();
        
        int[][] dp = new int[len1+1][len2+1];

        // 이중포문으로 기록하며 롱기사트썹시퀀스를 계산!
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                
                // 문자가 같을 경우 이전 대각선 값 dp[i-1][j-1]에 1을 더한다.
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                } else {
                    // 문자가 다를.경우 위쪽(dp[i-1][j])과 왼쪽(dp[i][j-1])을 참조
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }
        
        return dp[len1][len2];
    }

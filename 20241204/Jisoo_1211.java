class Solution {
    // Runtime 20 ms Beats 77.66% Analyze Complexity
    // Memory 50.63 MB Beats 71.75% Analyze Complexity
    public int longestCommonSubsequence1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] lcs = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[len1][len2];
    }

    // Runtime 18 ms Beats 91.59% Analyze Complexity
    // Memory 44.55 MB Beats 94.75% Analyze Complexity
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] before = new int[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            int[] now = new int[len2 + 1];
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    now[j] = before[j - 1] + 1;
                } else {
                    now[j] = Math.max(before[j], now[j - 1]);
                }
            }

            before = now;
        }

        return before[len2];
    }

}
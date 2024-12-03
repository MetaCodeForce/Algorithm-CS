class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] max = new int[1];
        findLCS(text1, 0, text2, 0, 0, max);

        return max[0];
    }

    private static void findLCS(String text1, int idx1, String text2, int idx2, int m, int[] max) {

        if (text1.length() <= idx1 || text2.length() <= idx2) {
            if (max[0] < m)
                max[0] = m;
        } else {
            // 선택 안할 경우 호출
            findLCS(text1, idx1, text2, idx2 + 1, m, max);

            while (text1.length() > idx1 && text2.length() > idx2 && text1.indexOf(text2.charAt(idx2), idx1) >= 0) {
                idx1 = text1.indexOf(text2.charAt(idx2), idx1) + 1;
                int n = idx2 + 1;

                while (text1.length() > idx1 && text2.length() > n && text1.charAt(idx1) == text2.charAt(n)) {
                    idx1++;
                    n++;
                }
                findLCS(text1, idx1, text2, n, m + (n - idx2), max);
            }
        }
    }
}
class YTW {
    public static void main(String[] args) {
        // YTW sol = new YTW();
        // sol.lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        int left_point_cursor = 0;
        int right_point_cursor = 0;

        String targetStr = "";
        String lastStr = "";
        Boolean isContain = null;
        int answer_longestNum = 0;

        while (!(s.length() == left_point_cursor
                && s.length() == right_point_cursor)) {

            // 우 point 이동
            while (true) {
                right_point_cursor += 1;
                targetStr = s.substring(left_point_cursor, right_point_cursor - 1);
                lastStr = targetStr.substring(right_point_cursor - 1, right_point_cursor);
                isContain = targetStr.contains(lastStr);
                if (isContain) {
                    answer_longestNum = answer_longestNum < targetStr.length() - 1 ? targetStr.length() - 1
                            : answer_longestNum;
                    break;
                } else {
                    continue;
                }
            }

            // 좌 point 이동
            while (true) {
                left_point_cursor += 1;
                targetStr = s.substring(left_point_cursor, right_point_cursor - 1);
                lastStr = targetStr.substring(right_point_cursor - 1, right_point_cursor);

                isContain = targetStr.contains(lastStr);
                if (isContain) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return answer_longestNum;
    }

}
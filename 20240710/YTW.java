// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left_point_cursor = 0;
//         int right_point_cursor = 0;

//         String targetStr = "";
//         String lastStr = "";
//         Boolean isContain = null;
//         int answer_longestNum = 0;

//         // 양 포인터가 마지막 노드에 있지 않다면 계속 진행
//         while (s.length() != right_point_cursor) {

//             // 우 point 이동
//             while (true) {
//                 right_point_cursor += 1;
//                 targetStr = s.substring(left_point_cursor, right_point_cursor);
//                 lastStr = targetStr.substring(right_point_cursor-1-left_point_cursor, right_point_cursor-left_point_cursor);

//                 isContain = targetStr.substring(0, right_point_cursor-1-left_point_cursor).contains(lastStr);
//                 if (isContain) {
//                     answer_longestNum = answer_longestNum < targetStr.length() - 1 ? targetStr.length() - 1
//                             : answer_longestNum;
//                     break;
//                 } else {
//                     continue;
//                 }
//             }

//             // 좌 point 이동
//             while (true) {
//                 left_point_cursor += 1;
//                 targetStr = s.substring(left_point_cursor, right_point_cursor);
//                 lastStr = targetStr.substring(right_point_cursor-1-left_point_cursor, right_point_cursor-left_point_cursor);

//                 isContain = targetStr.substring(0, right_point_cursor-1-left_point_cursor).contains(lastStr);
//                 if (isContain) {
//                     continue;
//                 } else {
//                     break;
//                 }
//             }
//         }
//         return answer_longestNum;
//     }
// }

class YTW {
    public static void main(String[] args) {
        // YTW sol = new YTW();
        // sol.lengthOfLongestSubstring("abcabcbb");
        // lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring(" ");
    }

    public static int lengthOfLongestSubstring(String s) {
        int left_point_cursor = 0;
        int right_point_cursor = 0;

        String targetStr = "";
        String lastStr = "";
        Boolean isContain = null;
        int answer_longestNum = 0;

        // 양 포인터가 마지막 노드에 있지 않다면 계속 진행
        while (s.length() != right_point_cursor) {

            // 우 point 이동
            while (true) {
                right_point_cursor += 1;
                
                
                targetStr = s.substring(left_point_cursor, right_point_cursor);
                lastStr = targetStr.substring(right_point_cursor-1-left_point_cursor, right_point_cursor-left_point_cursor);
                
                isContain = targetStr.substring(0, right_point_cursor-1-left_point_cursor).indexOf(lastStr)>=0;
                // " " : 공백은 contains 메소드로 체크
                if (isContain) {
                    answer_longestNum = answer_longestNum < targetStr.length() - 1 ? targetStr.length() - 1
                    : answer_longestNum;
                    break;
                // 마지막은 종료
                }else if(s.length() == right_point_cursor){
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

                // rigth부터 다시 시작
                if(left_point_cursor == right_point_cursor){
                    break;
                }

                targetStr = s.substring(left_point_cursor, right_point_cursor);
                lastStr = targetStr.substring(right_point_cursor-1-left_point_cursor, right_point_cursor-left_point_cursor);

                isContain = targetStr.substring(0, right_point_cursor-1-left_point_cursor).indexOf(lastStr)>=0;
                if (isContain || (lastStr.indexOf(" ") >= 0 && targetStr.indexOf(" ") >= 0)) {
                    continue;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer_longestNum);
        return answer_longestNum;
    }

}
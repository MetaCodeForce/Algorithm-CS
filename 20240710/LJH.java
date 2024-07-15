/**
 * 작성자 : 이재훈
 * 스터디 일시 : 2024/7/10
 * 문제 : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

// 투 포인터 알고리즘
//    1. i가 가리키는 문자열이 현재 부분 문자열에 포함이 안되면 i의 값을 1 늘려준다.
//    2. 포함을 하고있다면 문제의 조건을 만족하지 않으므로 prev 값을 1 늘려준다.
//    3. 현재 i의 값이 마지막 문자열을 넘었다면 종료한다.
class Solution {    public int lengthOfLongestSubstring(String s) {
    int answer = 0;
    int prev = 0;
    int i = 0;

    Set<Character> set = new HashSet<>();

    while(i < s.length()) {
        char curr = s.charAt(i);
        if(!set.contains(curr)) {
            set.add(curr);
            i++;
            answer = Math.max(answer, set.size());
        } else {
            set.remove(s.charAt(prev));
            prev++;
        }
    }
    return answer;
}
}